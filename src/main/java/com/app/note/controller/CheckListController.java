package com.app.note.controller;

import com.app.note.request.CheckListRequest;
import com.app.note.response.CheckListResponse;
import com.app.note.service.CheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/checklist")
public class CheckListController {
    @Autowired
    private CheckListService checkListService;

    @GetMapping(path="/{titleId}")
    public List<CheckListResponse> fetchLists(@PathVariable("titleId") Integer titleId, HttpServletResponse response){
       return checkListService.fetchLists(titleId, response);
    }

    @PostMapping
    public String createList(@RequestBody CheckListRequest checkListRequest, HttpServletResponse response){
         return checkListService.createList(checkListRequest,response);
    }

    @PutMapping
    public String updateList(@RequestBody CheckListRequest checkListRequest, HttpServletResponse response){
        return checkListService.updateList(checkListRequest, response);
    }
}
