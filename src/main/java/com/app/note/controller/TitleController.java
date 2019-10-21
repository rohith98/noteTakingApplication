package com.app.note.controller;

import com.app.note.entity.Title;
import com.app.note.request.TitleRequest;
import com.app.note.response.TitleResponse;
import com.app.note.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/titles"})
public class TitleController {

    @Autowired
    TitleService titleService;

    @PostMapping
    public TitleResponse fetchTitles(@RequestBody TitleRequest titleRequest){
        return titleService.fetchTitles(titleRequest.getGroupId());
    }
}
