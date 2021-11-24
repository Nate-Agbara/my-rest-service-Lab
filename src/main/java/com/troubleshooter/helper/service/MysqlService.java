package com.troubleshooter.helper.service;


import com.troubleshooter.helper.model.ErrorResponse;
import com.troubleshooter.helper.model.Users;

import java.util.List;
import java.util.Optional;

public interface MysqlService {

    int submit(String firstname, String lastname, String email);

    Optional<Users> findByID(int id);

    List<Users> returnUsers();
}
