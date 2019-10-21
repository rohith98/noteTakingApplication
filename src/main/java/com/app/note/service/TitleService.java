package com.app.note.service;

import com.app.note.entity.Title;
import com.app.note.repository.TitleRepository;
import com.app.note.request.TitleRequest;
import com.app.note.response.TitleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitleService {
    @Autowired
    TitleRepository titleRepository;

    public TitleResponse fetchTitles(Integer id){
        Optional<Title> title = titleRepository.findByGroupId(id);
        TitleResponse titleResponse = new TitleResponse();
        if(title.isPresent()){
            titleResponse.setTitleName(title.get().getTitleName());
//            titleResponse.setNotes(title.get().getNotes());
//            titleResponse.setLists(title.get().getLists());
        }
        return titleResponse;
    }

    public List<Title> findAll(){
        return titleRepository.findAll();
    }
}
