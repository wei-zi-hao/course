package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author EricWei on 2020/5/14
 */
@Service
public class ChapterServiceImpl implements ChapterService{
    @Resource
    private ChapterMapper chapterMapper;
    @Override
    public void selectChapter(ChapterPageDto chapterPageDto) {
        PageHelper.startPage(chapterPageDto.getPage(),chapterPageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        if (!StringUtils.isEmpty(chapterPageDto.getCourseId())) {
            criteria.andCourseIdEqualTo(chapterPageDto.getCourseId());

        }
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        chapterPageDto.setTotal(pageInfo.getTotal());
        List<ChapterDto> chapterDtoList = CopyUtil.copyList(chapterList, ChapterDto.class);
        chapterPageDto.setList(chapterDtoList);
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
