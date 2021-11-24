package com.troubleshooter.helper.repository;


import com.troubleshooter.helper.model.ErrorResponse;
import com.troubleshooter.helper.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface MysqlRepo extends CrudRepository<Users, Long> {


    @Modifying
    @Query(value = "insert into users (firstname, lastname, email) " +
            "values(?,?,?)", nativeQuery = true)
    @Transactional
    int submit(String firstname, String lastname, String email);

    @Query(value = "select * from users where id = ?",
            nativeQuery = true)
    @Transactional
    Optional<Users> findByID(int id);

//    public Optional<Users> get(int id) throws EmptyResultDataAccessException {
//        return Optional.ofNullable(jdbcTemplate.queryForObject(
//                "select * from users where id = ?",
//                new Object[]{id},
//                (rs, rowNum) -> {
//                    Users users = new Users();
//                    users.setId(rs.getInt("userid"));
//                    users.setFirstname(rs.getString("firstname"));
//                    users.setLastname((rs.getString("lastname")));
//                    users.setEmail(rs.getString("email"));
//                    return users;
//                }
//        ));
//    }

}
