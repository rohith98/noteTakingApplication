package com.app.note.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="titles")
public class Title {
    @Id
    @Column(name="title_id")
    private Integer titleId;

    @Column(name="group_id")
    private Integer groupId;

    @Column(name="title_name")
    private String titleName;
    
    @OneToMany
    @JoinColumn(name = "title_id")
    private List<Note> notes;

    @OneToMany
    @JoinColumn(name = "title_id")
    private List<com.app.note.entity.List> lists;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<com.app.note.entity.List> getLists() {
        return lists;
    }

    public void setLists(List<com.app.note.entity.List> lists) {
        this.lists = lists;
    }
}
