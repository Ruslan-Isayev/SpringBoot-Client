package com.project.client.service;

import com.project.client.dto.response.RespCustomer;
import com.project.client.dto.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    Response<List<RespCustomer>> getCustomerList();
}
