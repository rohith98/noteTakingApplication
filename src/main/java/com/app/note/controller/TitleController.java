package com.app.note.controller;

import com.app.note.entity.Title;
import com.app.note.request.TitleRequest;
import com.app.note.response.TitleResponse;
import com.app.note.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/title"})
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping(path="/{groupId}")
    public List<TitleResponse> fetchTitles(@PathVariable("groupId") Integer groupId, HttpServletResponse response){
        return titleService.fetchTitles(groupId,response);
    }

    @PostMapping
    public String createTitle(@RequestBody TitleRequest titleRequest, HttpServletResponse response){
        return titleService.createTitle(titleRequest, response);
    }

    @PutMapping
    public String updateTitleName(@RequestBody TitleRequest titleRequest, HttpServletResponse response){
        return titleService.updateTitleName(titleRequest, response);
    }

    @DeleteMapping(("/{titleId}"))
    public String deleteTitle(@PathVariable("titleId") Integer titleId, HttpServletResponse response){
        return titleService.deleteTitle(titleId, response);
    }

    @GetMapping(("/search/{search}"))
    public List<TitleResponse> searchByName(@PathVariable("search") String search){
        return titleService.searchByName(search);
    }

    @GetMapping(("/searchAll/{search}"))
    public List<TitleResponse> searchAll(@PathVariable("search") String search){
        return titleService.searchAll(search);
    }
}
