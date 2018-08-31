package com.marksman.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author weilb
 * @date 2018/8/31
 * @description
 */
@FeignClient(value = "service-hi")
public interface SchedualServiceHi {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}