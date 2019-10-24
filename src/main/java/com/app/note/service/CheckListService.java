package com.app.note.service;

import com.app.note.entity.CheckList;
import com.app.note.entity.Title;
import com.app.note.repository.CheckListRepository;
import com.app.note.repository.TitleRepository;
import com.app.note.request.CheckListRequest;
import com.app.note.response.CheckListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckListService {
    @Autowired
    private CheckListRepository checkListRepository;

    @Autowired
    private TitleRepository titleRepository;

    private static Logger logger = LoggerFactory.getLogger(CheckListService.class);

    public List<CheckListResponse> fetchLists(Integer titleId, HttpServletResponse response){
        List<CheckListResponse> checkListResponses = new ArrayList<>();
        try{
            Title title = titleRepository.findById(titleId).orElseThrow(()-> new Exception("Title Not Found"));
            List<CheckList> lists = checkListRepository.findAllByTitle(title);
            for(CheckList list: lists){
                CheckListResponse checkListResponse = new CheckListResponse();
                checkListResponse.setListId(list.getListId());
                checkListResponse.setListName(list.getListName());
                checkListResponse.setCheckBox(list.getCheckBox());
                checkListResponses.add(checkListResponse);
            }
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        catch (Exception e){
           logger.error(e.getMessage());
           response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return checkListResponses;
    }

    public void createList(CheckListRequest checkListRequest, HttpServletResponse response){
        try{
            Title title = titleRepository.findById(checkListRequest.getTitleId()).orElseThrow(()-> new Exception("Title Not Found"));
            CheckList list = new CheckList();
            list.setTitle(title);
            list.setListName(checkListRequest.getListName());
            list.setCheckBox(checkListRequest.getCheckBox());
            checkListRepository.save(list);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public String updateList(CheckListRequest checkListRequest, HttpServletResponse response){
        try{
            CheckList list = new CheckList();
            list.setListId(checkListRequest.getListId());
            list.setListName(checkListRequest.getListName());
            list.setCheckBox(checkListRequest.getCheckBox());
            checkListRepository.save(list);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "CheckList Updated Successfully";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}
