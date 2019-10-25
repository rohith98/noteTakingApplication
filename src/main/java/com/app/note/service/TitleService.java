package com.app.note.service;

import com.app.note.entity.Group;
import com.app.note.entity.Title;
import com.app.note.repository.GroupRepository;
import com.app.note.repository.TitleRepository;
import com.app.note.request.TitleRequest;
import com.app.note.response.TitleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TitleService {
    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private GroupRepository groupRepository;

    private static Logger logger = LoggerFactory.getLogger(TitleService.class);

    public List<TitleResponse> fetchTitles(Integer id, HttpServletResponse response){
        List<TitleResponse> titleResponses = new ArrayList<>();
        try{
            Group group = groupRepository.findById(id).orElseThrow(()-> new Exception("Group Not Found"));
            List<Title> titles = titleRepository.findAllByGroup(group);
            for(Title title: titles){
                TitleResponse titleResponse = new TitleResponse();
                titleResponse.setTitleId(title.getTitleId());
                titleResponse.setTitleName(title.getTitleName());
                titleResponses.add(titleResponse);
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return titleResponses;
    }

    public String createTitle(TitleRequest titleRequest, HttpServletResponse response){
        try{
            Group group = groupRepository.findById(titleRequest.getGroupId()).orElseThrow(()-> new Exception("Group Not Found"));
            Title title = new Title();
            title.setGroup(group);
            title.setTitleName(titleRequest.getTitleName());
            titleRepository.save(title);
            response.setStatus(HttpServletResponse.SC_CREATED);
            return "Title Created Successfully ";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "Error Creating Title";
        }
    }

    public String updateTitleName(TitleRequest titleRequest,HttpServletResponse response){
        try{
            Title title = titleRepository.findById(titleRequest.getTitleId()).orElseThrow(()-> new Exception("Title Not Found"));
            title.setTitleName(titleRequest.getTitleName());
            titleRepository.save(title);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "Title Updated Successfully ";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "Error Updating Title";
        }
    }

    public String deleteTitle(Integer titleId, HttpServletResponse response){
        try{
            titleRepository.deleteById(titleId);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            return "Title Deleted Successfully ";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return "Error Deleting Title";
        }
    }

    public List<TitleResponse> searchByName(String search){
        List<TitleResponse> titleResponses =  new ArrayList<>();
        try{
            List<Title> titles = titleRepository.findByName(search);
            for(Title title: titles){
                TitleResponse titleResponse = new TitleResponse();
                titleResponse.setTitleId(title.getTitleId());
                titleResponse.setTitleName(title.getTitleName());
                titleResponses.add(titleResponse);
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return titleResponses;
    }
}
