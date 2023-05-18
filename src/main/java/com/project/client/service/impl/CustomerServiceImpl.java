package com.project.client.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.client.dto.request.ReqLogin;
import com.project.client.dto.response.RespCustomer;
import com.project.client.dto.response.RespUser;
import com.project.client.dto.response.Response;
import com.project.client.service.CustomerService;
import com.project.client.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
@PropertySource("classpath:config.properties")
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final Utility utility;

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.username}")
    private String apiUsername;

    @Value("${api.password}")
    private String apiPassword;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Response<List<RespCustomer>> getCustomerList() {
        Response<List<RespCustomer>> resp = new Response<>();
        try {
            ReqLogin reqLogin = new ReqLogin();
            reqLogin.setUsername(apiUsername);
            reqLogin.setPassword(apiPassword);
            String reqLoginJson = objectMapper.writeValueAsString(reqLogin);
            String result = utility.sendPost(apiUrl + "user/login", reqLoginJson);
            Response<RespUser> response = objectMapper.readValue(result, new TypeReference<Response<RespUser>>() {});
            if (response.getStatus().getCode() != 1) {
                resp.setStatus(response.getStatus());
                return resp;
            }
            String reqTokenJson = objectMapper.writeValueAsString(response.getT().getRespToken());
            String customerListResult = utility.sendPost(apiUrl + "customer/getCustomerList", reqTokenJson);
            resp = objectMapper.readValue(customerListResult, new TypeReference<Response<List<RespCustomer>>>() {});
            System.out.println(resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}