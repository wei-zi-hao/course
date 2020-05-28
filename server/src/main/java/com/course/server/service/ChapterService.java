package com.course.server.service;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;

/**
 * @author EricWei on 2020/5/14
 */
public interface ChapterService {
   public void selectChapter(PageDto pageDto);

    public void save(ChapterDto chapterDto);
}
