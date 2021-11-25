package com.troubleshooter.helper.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@ApiModel(description = "Success Response model")
public class SuccessResponse {

    @ApiModelProperty(notes = "Error code", name = "code", value = "200")
    private int code;

    @ApiModelProperty(notes = "Status", name = "status", value = "SUCCESS")
    private String status;

    @ApiModelProperty(notes = "Message", name = "message", value = "Invalid field")
    private String message;

}
