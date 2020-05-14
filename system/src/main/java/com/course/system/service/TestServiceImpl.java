package com.course.system.service;

import com.course.system.domain.Test;
import com.course.system.mapper.TestMapper;
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
