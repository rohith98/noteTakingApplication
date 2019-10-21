package com.app.note.service;

import com.app.note.entity.Note;
import com.app.note.entity.Title;
import com.app.note.repository.NoteRepository;
import com.app.note.repository.TitleRepository;
import com.app.note.response.NoteResponse;
import com.app.note.response.TitleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {
    @Autowired
    NoteRepository noteRepository;

    public NoteResponse fetchNote(Integer titleId){
        Note note = noteRepository.findByTitleId(titleId);

        NoteResponse noteResponse = new NoteResponse();

        noteResponse.setMessage(note.getMessage());

        return noteResponse;
    }
}
