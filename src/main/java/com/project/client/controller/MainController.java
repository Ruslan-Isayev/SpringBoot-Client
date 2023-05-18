package com.project.client.controller;

import com.project.client.dto.response.RespCustomer;
import com.project.client.dto.response.Response;
import com.project.client.service.AccountService;
import com.project.client.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final AccountService accountService;

    private final CustomerService customerService;


    @GetMapping("/getCustomerList")
    public ModelAndView getCustomerList() {
        ModelAndView model = new ModelAndView();
        Response<List<RespCustomer>> result = customerService.getCustomerList();
        model.addObject("result", result);
        return model;
    }

    @GetMapping("/getAccountList/{customerId}")
    public void getAccountList(@PathVariable Long customerId) {
        String result = accountService.getAccountList(customerId);
        System.out.println(result);
    }
}
