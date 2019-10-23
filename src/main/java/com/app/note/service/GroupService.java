package com.app.note.service;

import com.app.note.entity.Group;
import com.app.note.entity.User;
import com.app.note.repository.GroupRepository;
import com.app.note.repository.UserRepository;
import com.app.note.request.GroupRequest;
import com.app.note.response.GroupResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(GroupService.class);

    public List<GroupResponse> fetchGroups(Integer userId, HttpServletResponse response){
        List<GroupResponse> groupResponses = new ArrayList<>();
        try{
            User user = userRepository.findById(userId).orElseThrow(()-> new Exception("User Not Found"));
            List<Group> groups = groupRepository.findAllByUser(user);
            for(Group group: groups)
            {
                GroupResponse groupResponse = new GroupResponse();
                groupResponse.setGroupId(group.getGroupId());
                groupResponse.setGroupName(group.getGroupName());
                groupResponses.add(groupResponse);
            }
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return groupResponses;
    }

    public void createGroup(GroupRequest groupRequest, HttpServletResponse response){
        try{
            User user = userRepository.findById(groupRequest.getUserId()).orElseThrow(()->new Exception("User Not Found"));
            Group group = new Group();
            group.setUser(user);
            group.setGroupName(groupRequest.getGroupName());
            groupRepository.save(group);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void updateGroupName(GroupRequest groupRequest, HttpServletResponse response){
        try{
            Group group = groupRepository.findById(groupRequest.getGroupId()).orElseThrow(()->new Exception("Group Not Found"));
            group.setGroupName(groupRequest.getGroupName());
            groupRepository.save(group);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void deleteGroup(Integer groupId, HttpServletResponse response){
        try{
            groupRepository.deleteById(groupId);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
