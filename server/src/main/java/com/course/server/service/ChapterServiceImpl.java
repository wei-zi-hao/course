package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.dto.ChapterDto;
import com.course.server.mapper.ChapterMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
@Service
public class ChapterServiceImpl implements ChapterService{
    @Resource
    private ChapterMapper chapterMapper;
    @Override
    public List<ChapterDto> selectChapter() {
        List<Chapter> chapters = chapterMapper.selectByExample(null);
        ArrayList<ChapterDto> chapterDtoList = new ArrayList<>();
        for (int i = 0; i < chapters.size(); i++) {
            Chapter chapter = chapters.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        return chapterDtoList;

    }
}