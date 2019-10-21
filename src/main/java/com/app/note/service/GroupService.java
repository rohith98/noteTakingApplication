package com.app.note.service;

import com.app.note.entity.Group;
import com.app.note.repository.GroupRepository;
import com.app.note.request.GroupRequest;
import com.app.note.response.GroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    GroupRepository groupRepository;

    public List<GroupResponse> display(Integer UserId ){
        List<Group> groups = groupRepository.findAllByUserId(UserId);
        List<GroupResponse> groupResponses = new ArrayList<>();
        for(Group group: groups)
        {
            GroupResponse groupResponse = new GroupResponse();

            groupResponse.setGroupName(group.getGroupName());

            groupResponses.add(groupResponse);
        }
        return groupResponses;
    }

    public String create(GroupRequest groupRequest){
        Group group = new Group();

        group.setUserId(groupRequest.getUserId());
        group.setGroupName(groupRequest.getGroupName());

        groupRepository.save(group);

        return "Success";
    }
}
