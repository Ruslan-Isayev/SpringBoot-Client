package com.project.client.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.client.dto.request.ReqLogin;
import com.project.client.service.CustomerService;
import com.project.client.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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
    public String getCustomerList() {
        try {
            ReqLogin reqLogin = new ReqLogin();
            reqLogin.setUsername(apiUsername);
            reqLogin.setPassword(apiPassword);
            String reqLoginJson = objectMapper.writeValueAsString(reqLogin);
            String result = utility.sendPost(apiUrl + "user/login", reqLoginJson);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}