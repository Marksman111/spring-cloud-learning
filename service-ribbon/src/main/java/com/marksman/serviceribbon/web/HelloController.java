package com.marksman.serviceribbon.web;

import com.marksman.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weilb
 * @date 2018/8/31
 * @description
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
}
