package com.course.server.service;

import com.course.server.domain.Test;
import com.course.server.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
@Service
public class TestServiceImpl implements TestService{
    @Resource
    private TestMapper testMapper;
    @Override
    public List<Test> selectTest() {
        return testMapper.selectTest();
    }
}
