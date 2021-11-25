package com.troubleshooter.helper.model;



//import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID of the user", name = "id", required = true, value = "234567")
    private int id;

    //@NotNull(message = "First Name cannot be null")
    @ApiModelProperty(notes = "firstname of the user", name = "firstname", required = true, value = "John")
    private String firstname;

    //@NotNull(message = "Last Name cannot be null")
    @ApiModelProperty(notes = "lastname of the user", name = "id", required = true, value = "Doe")
    private String lastname;

    //@NotNull(message = "Email cannot be null")
    @ApiModelProperty(notes = "email of the user", name = "id", required = true, value = "johndoe@example.com")
    private String email;

}
