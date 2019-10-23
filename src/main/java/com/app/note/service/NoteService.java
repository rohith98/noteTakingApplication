package com.app.note.service;

import com.app.note.entity.Note;
import com.app.note.entity.Title;
import com.app.note.repository.NoteRepository;
import com.app.note.repository.TitleRepository;
import com.app.note.request.NoteRequest;
import com.app.note.response.NoteResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import javax.servlet.http.HttpServletResponse;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TitleRepository titleRepository;

    private static Logger logger = LoggerFactory.getLogger(NoteService.class);

    public NoteResponse fetchNote(Integer titleId){
        NoteResponse noteResponse = new NoteResponse();
        try{
            Title title = titleRepository.findById(titleId).orElseThrow(()-> new Exception("Title Note Found"));
            Note note = noteRepository.findByTitle(title);
            noteResponse.setNoteId(note.getNoteId());
            noteResponse.setMessage(note.getMessage());
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return noteResponse;
    }

    public void createNote(NoteRequest noteRequest, HttpServletResponse response){
        try{
            Title title = titleRepository.findById(noteRequest.getTitleId()).orElseThrow(()-> new Exception("Title Not Found"));
            Note note = new Note();
            note.setTitle(title);
            note.setMessage(noteRequest.getMessage());
            noteRepository.save(note);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }
        catch (Exception e){
            logger.error(e.getMessage());
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public String updateNote(NoteRequest noteRequest, HttpServletResponse response){
        try{
            Note note = new Note();
            note.setNoteId(noteRequest.getNoteId());
            note.setMessage(noteRequest.getMessage());
            noteRepository.save(note);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return "Message Updated Successfully";
        }
        catch (Exception e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }
}
