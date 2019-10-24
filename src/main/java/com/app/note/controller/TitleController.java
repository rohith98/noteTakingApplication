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
        titleService.createTitle(titleRequest, response);
        if(response.getStatus()==HttpServletResponse.SC_CREATED){
            return "Title Created Successfully ";
        }
        else{
            return "Error Creating Title";
        }
    }

    @PutMapping
    public String updateTitleName(@RequestBody TitleRequest titleRequest, HttpServletResponse response){
        titleService.updateTitleName(titleRequest, response);
        if(response.getStatus()==HttpServletResponse.SC_ACCEPTED){
            return "Title Updated Successfully ";
        }
        else{
            return "Error Updating Title";
        }
    }

    @DeleteMapping(("/{titleId}"))
    public String deleteTitle(@PathVariable("titleId") Integer titleId, HttpServletResponse response){
        titleService.deleteTitle(titleId, response);
        if(response.getStatus()==HttpServletResponse.SC_NO_CONTENT){
            return "Title Deleted Successfully ";
        }
        else{
            return "Error Deleting Title";
        }
    }

    @GetMapping(("/search/{search}"))
    public List<TitleResponse> searchByName(@PathVariable("search") String search){
        return titleService.searchByName(search);
    }
}
