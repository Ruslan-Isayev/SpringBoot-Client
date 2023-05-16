package com.project.client.service;

import com.project.client.dto.request.ReqLogin;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String login(ReqLogin reqLogin);
}
