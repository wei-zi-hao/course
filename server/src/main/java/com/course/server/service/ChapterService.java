package com.course.server.service;

import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;

/**
 * @author EricWei on 2020/5/14
 */
public interface ChapterService {
   public void selectChapter(ChapterPageDto chapterPageDto);

    public void save(ChapterDto chapterDto);

    public void delete(String id);
}
