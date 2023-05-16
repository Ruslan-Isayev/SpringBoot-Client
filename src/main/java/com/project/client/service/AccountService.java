package com.project.client.service;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public String getAccountList(Long customerId);

}
