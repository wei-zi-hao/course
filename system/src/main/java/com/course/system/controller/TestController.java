package com.course.system.controller;

import com.course.system.domain.Test;
import com.course.system.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author EricWei on 2020/5/11
 */
@RestController
public class TestController {

    @Autowired
   private TestService testService;
    @RequestMapping("/test")
    public List<Test> test(){
        return testService.selectTest();
    }
}
