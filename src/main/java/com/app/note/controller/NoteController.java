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
        return noteService.fetchNote(titleId, response);
    }

    @PostMapping
    public String createNote(@RequestBody NoteRequest noteRequest, HttpServletResponse response){
        return noteService.createNote(noteRequest, response);
    }

    @PutMapping
    public String updateNote(@RequestBody NoteRequest noteRequest, HttpServletResponse response){
        return noteService.updateNote(noteRequest, response);
    }
}
