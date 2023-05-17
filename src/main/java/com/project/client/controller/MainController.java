package com.project.client.controller;

import com.project.client.service.AccountService;
import com.project.client.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final AccountService accountService;

    private final CustomerService customerService;



    @GetMapping("/getCustomerList")
    public void getCustomerList() {
//        ModelAndView model = new ModelAndView();
        String result = customerService.getCustomerList();
        System.out.println(result);
    }

    @GetMapping("/getAccountList/{customerId}")
    public void getAccountList(@PathVariable Long customerId) {
        String result = accountService.getAccountList(customerId);
        System.out.println(result);
    }
}
