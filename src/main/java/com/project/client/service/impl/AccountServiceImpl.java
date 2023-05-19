package com.project.client.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.client.dto.response.RespAccount;
import com.project.client.dto.response.Response;
import com.project.client.service.AccountService;
import com.project.client.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class AccountServiceImpl implements AccountService {

    private final Utility utility;

    @Value("${api.url}")
    private String apiUrl;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response<List<RespAccount>> getAccountList(Long customerId) {
        Response<List<RespAccount>> response = new Response<>();
        try {
            String url = apiUrl + "account/getAccountListByCustomerId/" + customerId;
            String result = utility.sendGet(url);
            response = objectMapper.readValue(result, new TypeReference<Response<List<RespAccount>>>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
