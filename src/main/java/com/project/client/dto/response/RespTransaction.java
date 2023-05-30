package com.project.client.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespTransaction {
    private Long id;
    private RespAccount dtAccount;
    private String crAccount;
    private Double amount;
    private Double commission;
    private String currency;
    private Date trDate;
}
