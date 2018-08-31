package com.marksman.servicefeign.service.impl;

import com.marksman.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author weilb
 * @date 2018/8/31
 * @description
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}