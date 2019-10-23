package com.app.note.controller;

import com.app.note.entity.Title;
import com.app.note.request.NoteRequest;
import com.app.note.response.NoteResponse;
import com.app.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping({"/note"})
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping(path="/{titleId}")
    public NoteResponse fetchNote(@PathVariable("titleId") Integer titleId, HttpServletResponse response){
        NoteResponse noteResponse = noteService.fetchNote(titleId);
        if(noteResponse.getNoteId()!=null){
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return noteResponse;
    }

    @PostMapping
    public String createNote(@RequestBody NoteRequest noteRequest, HttpServletResponse response){
        noteService.createNote(noteRequest, response);
        if(response.getStatus()==HttpServletResponse.SC_CREATED){
            return "Note Created Successfully ";
        }
        else{
            return "Error Creating Note";
        }
    }

    @PutMapping
    public String updateNote(@RequestBody NoteRequest noteRequest, HttpServletResponse response){
        return noteService.updateNote(noteRequest, response);
    }
}
