package com.app.note.controller;

import com.app.note.entity.Group;
import com.app.note.request.GroupRequest;
import com.app.note.response.GroupResponse;
import com.app.note.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/group"})
public class GroupController {
    @Autowired
    private GroupService groupService;

    @GetMapping(path="/{userId}")
    public List<GroupResponse> fetchGroups(@PathVariable("userId") Integer userId, HttpServletResponse response){
        return groupService.fetchGroups(userId, response);
    }

    @PostMapping
    public String createGroup(@RequestBody GroupRequest groupRequest,  HttpServletResponse response){
        return groupService.createGroup(groupRequest, response);
    }

    @PutMapping
    public String updateGroupName(@RequestBody GroupRequest groupRequest,  HttpServletResponse response){
        return groupService.updateGroupName(groupRequest, response);
    }

    @DeleteMapping(("/{groupId}"))
    public String deleteGroup(@PathVariable("groupId") Integer groupId,  HttpServletResponse response){
        return groupService.deleteGroup(groupId, response);
    }

    @GetMapping(("/search/{search}"))
    public List<GroupResponse> searchByName(@PathVariable("search") String search){
        return groupService.searchByName(search);
    }
}
