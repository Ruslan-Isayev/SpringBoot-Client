package com.project.client.dto.response;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespCustomer {
    private Long customerId;
    private String name;
    private String surname;
    private Date dob;
    private String phone;
    private String cif;
}
