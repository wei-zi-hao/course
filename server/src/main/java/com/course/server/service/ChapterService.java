package com.course.server.service;

import com.course.server.dto.ChapterDto;

import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
public interface ChapterService {
   public List<ChapterDto> selectChapter();
}
