package com.app.note.entity;

import javax.persistence.*;

@Entity
@Table(name="notes")
//@NamedNativeQuery(name="createNote",query="insert into Note (title_id, message) values(:titleId, :message)")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notes_id")
    private Integer noteId;

//    @Column(name="title_id")
//    private Integer titleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="title_id")
    private Title title;

    @Column(name="message")
    private String message;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

//    public Integer getTitleId() {
//        return titleId;
//    }
//
//    public void setTitleId(Integer titleId) {
//        this.titleId = titleId;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
