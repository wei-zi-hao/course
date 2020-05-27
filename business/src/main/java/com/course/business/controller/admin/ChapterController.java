package com.course.business.controller.admin;

import com.course.server.dto.PageDto;
import com.course.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EricWei on 2020/5/11
 */
@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Autowired
   private ChapterService chapterService;
    @RequestMapping("/list")
    public PageDto selectChapter(@RequestBody PageDto pageDto){
        chapterService.selectChapter(pageDto);
        return pageDto;
    }
}
