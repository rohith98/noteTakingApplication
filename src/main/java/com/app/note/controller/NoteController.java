package com.app.note.controller;

import com.app.note.request.NoteRequest;
import com.app.note.response.NoteResponse;
import com.app.note.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/note"})
public class NoteController {
    @Autowired
    NoteService noteService;

    @PostMapping
    public NoteResponse fetchNote(@RequestBody NoteRequest noteRequest){
        return noteService.fetchNote(noteRequest.getTitleId());
    }
}
