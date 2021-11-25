package com.troubleshooter.helper.service;


import com.troubleshooter.helper.model.ErrorResponse;
import com.troubleshooter.helper.model.Users;
import com.troubleshooter.helper.repository.MysqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MysqlServiceImpl implements MysqlService {

    private MysqlRepo mysqlRepo;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MysqlServiceImpl() {
    }

    @Autowired
    public MysqlServiceImpl(MysqlRepo mysqlRepo) {
        this.mysqlRepo = mysqlRepo;
    }

    @Override
    public int submit(String firstname, String lastname, String email){
        return mysqlRepo.submit(firstname, lastname, email);
    }

    public Optional<Users> findByID(int id)  {
          return Optional.ofNullable(jdbcTemplate.queryForObject(
                "select * from users where id = ?",
               // new Object[]{id},
                (rs, rowNum) -> {
                    Users users = new Users();
                    users.setId(rs.getInt("id"));
                    users.setFirstname(rs.getString("firstname"));
                    users.setLastname((rs.getString("lastname")));
                    users.setEmail(rs.getString("email"));
                    return users;
                }
        ,id));
          //.orElseThrow(throw  EmptyResultDataAccessException::new);'

    }

    @Override
    public List<Users> returnUsers(){
        return jdbcTemplate.query(
                "select * from users",
                //new Object[]{},
                (rs, rowNum) -> {
                    Users users = new Users();
                    users.setId(rs.getInt("id"));
                    //order.setCreated(rs.getDate("created"));
                    users.setFirstname(rs.getString("firstname"));
                    users.setLastname(rs.getString("lastname"));
                    users.setEmail(rs.getString("email"));
                    return users;
                });
    }

}
