package com.course.server.service;

import com.course.server.domain.Test;

import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
public interface TestService {
    public List<Test> selectTest();
}
