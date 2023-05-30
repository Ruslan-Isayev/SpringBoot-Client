package com.project.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespAccount {
    private Long id;
    private String name;
    private String accountNo;
    private String iban;
    private String currency;
    private String branchCode;
    private RespCustomer customer;
}
