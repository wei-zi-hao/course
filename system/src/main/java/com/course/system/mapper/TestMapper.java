package com.course.system.mapper;

import com.course.system.domain.Test;

import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
public interface TestMapper {
    List<Test> selectTest();
}
