package com.project.client.service;

import com.project.client.dto.response.RespAccount;
import com.project.client.dto.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Response<List<RespAccount>> getAccountList(Long customerId);

}
