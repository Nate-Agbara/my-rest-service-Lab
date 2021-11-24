package com.troubleshooter.helper.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "Error Response model")
public class ErrorResponse implements Serializable {

    @ApiModelProperty(notes = "Error code", name = "code", value = "200")
    private int code;

    @ApiModelProperty(notes = "Status", name = "status", value = "SUCCESS")
    private String status;

    @ApiModelProperty(notes = "Message", name = "message", value = "Invalid field")
    private String message;

}
