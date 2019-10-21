package com.app.note.controller;

import com.app.note.entity.Group;
import com.app.note.request.GroupRequest;
import com.app.note.response.GroupResponse;
import com.app.note.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/group"})
public class GroupController {
    @Autowired
    GroupService groupService;

    @PostMapping
    public List<GroupResponse> fetchGroups(@RequestBody GroupRequest groupRequest){
        return groupService.display(groupRequest.getUserId());
    }

    @PostMapping({"/create"})
    public String createGroup(@RequestBody GroupRequest groupRequest){
        return groupService.create(groupRequest);
    }
}
