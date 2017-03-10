package com.trs.springboot.start;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yuanwenjie on 2016/11/23.
 */
@RestController
public class BootAction {
    @RequestMapping("spring-boot")
    public String bootIndex(){
        System.out.println("==============");
        return "hello spring-boot-------";
    }
}
