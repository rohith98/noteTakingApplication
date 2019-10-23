package com.app.note.controller;

import com.app.note.request.CheckListRequest;
import com.app.note.response.CheckListResponse;
import com.app.note.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/list")
public class CheckListController {
    @Autowired
    private CheckListService checkListService;

    @GetMapping(path="/{titleId}")
    public List<CheckListResponse> fetchLists(@PathVariable("titleId") Integer titleId, HttpServletResponse response){
       return checkListService.fetchLists(titleId, response);
    }

    @PostMapping
    public String createList(@RequestBody CheckListRequest checkListRequest, HttpServletResponse response){
         checkListService.createList(checkListRequest,response);
         if(response.getStatus()==HttpServletResponse.SC_CREATED){
             return "Check List Created Successfully ";
         }
         else{
             return "Error Creating Check List";
         }
    }

    @PutMapping
    public String updateList(@RequestBody CheckListRequest checkListRequest, HttpServletResponse response){
        return checkListService.updateList(checkListRequest, response);
    }
}
