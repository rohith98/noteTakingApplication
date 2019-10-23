package com.app.note.request;

import com.app.note.entity.CheckList;
import com.app.note.entity.Note;

import java.util.List;

public class TitleRequest {
    private Integer titleId;

    private Integer groupId;

    private String titleName;

    private List<Note> notes;

    private List<CheckList> lists;

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

    public List<CheckList> getLists() {
        return lists;
    }

    public void setLists(List<CheckList> lists) {
        this.lists = lists;
    }
}
