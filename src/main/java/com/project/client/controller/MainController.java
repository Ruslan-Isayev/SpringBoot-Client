package com.project.client.controller;

import com.project.client.dto.response.RespAccount;
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


    @GetMapping({"/", "/getCustomerList"})
    public ModelAndView getCustomerList() {
        ModelAndView model = new ModelAndView("index");
        Response<List<RespCustomer>> result = customerService.getCustomerList();
        if (result.getStatus().getCode() == 1) {
            model.addObject("result", result.getT());
        } else {
            model.addObject("message", result.getStatus().getMessage());
        }
        return model;
    }

    @GetMapping("/getAccountList/{customerId}")
    public ModelAndView getAccountList(@PathVariable Long customerId) {
        ModelAndView model = new ModelAndView("account");
        Response<List<RespAccount>> result = accountService.getAccountList(customerId);
        if (result.getStatus().getCode() == 1) {
            model.addObject("result", result.getT());
        } else {
            model.addObject("message", result.getStatus().getMessage());
        }
        return model;
    }
}
