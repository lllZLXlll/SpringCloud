package com.zlx.redispublisher.controller;

import com.zlx.redispublisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    /**
     * push 消息
     *
     * @param params
     * @return
     */
    @GetMapping("pushMsg")
    public String pushMsg(String params) {
        return publisherService.pushMsg(params);
    }
}
