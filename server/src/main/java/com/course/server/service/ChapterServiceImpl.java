package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public void selectChapter(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        List<Chapter> chapters = chapterMapper.selectByExample(null);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapters);
        pageDto.setTotal(pageInfo.getTotal());
        ArrayList<ChapterDto> chapterDtoList = new ArrayList<>();
        for (int i = 0; i < chapters.size(); i++) {
            Chapter chapter = chapters.get(i);
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);
        System.out.println(pageDto);
    }

    @Override
    public void save(ChapterDto chapterDto) {
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto,chapter);
        if(StringUtils.isEmpty(chapterDto.getId())){
            insert(chapter);
        }else{
            update(chapter);
        }
    }


    private void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }
    private void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    @Override
    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }
}
