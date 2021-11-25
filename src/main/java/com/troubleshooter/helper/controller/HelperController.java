package com.troubleshooter.helper.controller;


import com.troubleshooter.helper.model.ErrorResponse;
import com.troubleshooter.helper.model.SuccessResponse;
import com.troubleshooter.helper.model.Users;
import com.troubleshooter.helper.service.MysqlService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@ApiOperation(value = "/helper/vi/users", tags = "Helper Controller")
@RestController
public class HelperController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private MysqlService mysqlService;

    @Autowired
    public HelperController(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @ApiOperation(value = "submit a user details", response = String.class)
    @PostMapping("/PostUser")
    public ResponseEntity<?> postUser(@RequestBody Users users){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        ErrorResponse errorResponse;
        long submitResponse = mysqlService.submit(users.getFirstname(), users.getLastname(), users.getEmail());
        log.info("Response from database insert: "+submitResponse);
        if(submitResponse == 0){
             errorResponse = new ErrorResponse(200, "01", "NOT SUCCESSFUL");
        }else{
             errorResponse = new ErrorResponse(200, "00", "SUCCESS");
        }
        return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.OK);

    }

    @ApiOperation(value = "fetch a user by ID", response = Users.class)
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Optional<Users> get(@PathVariable int id) {
            Optional<Users> users = mysqlService.findByID(id);
            users.ifPresentOrElse(
                    o -> log.info("get {}: {}", id, o),
                    //() ->   throw new EmptyResultDataAccessException(); );
                    () -> log.info("get {}: null", id));
            return users;

    }

    @ApiOperation(value = "fetch all users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "SUCCESS", response = Users.class),
            @ApiResponse(code = 401, message = "UNAUTHORIZED", response = ErrorResponse.class),
            @ApiResponse(code = 403, message = "FORBIDDEN", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "NOT FOUND")
    })
    @RequestMapping("/fetch/all")
    @ResponseBody
    public ResponseEntity<?> get() {
        JSONObject responsemsg = new JSONObject();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        List<Users> users = mysqlService.returnUsers();
        responsemsg.put("status", "00");
        responsemsg.put("message", "SUCCESS");
        responsemsg.put("Data", users);
        log.info(users.toString());
        log.info(responsemsg.toString());
        return new ResponseEntity<>(responsemsg.toString(), responseHeaders, HttpStatus.OK);
    }

}
