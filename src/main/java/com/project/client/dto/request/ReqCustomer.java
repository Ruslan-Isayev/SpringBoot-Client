package com.project.client.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReqCustomer {
    private Long customerId;
    private String name;
    private String surname;
    private Date dob;
    private String phone;
    private String cif;
    @JsonProperty(value = "token")
    private ReqToken reqToken;
}