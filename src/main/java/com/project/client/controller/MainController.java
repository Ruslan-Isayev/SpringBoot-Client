package com.project.client.controller;

import com.project.client.service.AccountService;
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

    @PostMapping("/getCustomerList")
    public ModelAndView getCustomerList() {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @GetMapping("/getAccountList/{customerId}")
    public void getAccountList(@PathVariable Long customerId) {
        String result = accountService.getAccountList(customerId);
        System.out.println(result);
    }
}
