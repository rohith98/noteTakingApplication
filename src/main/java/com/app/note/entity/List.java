package com.app.note.entity;

import javax.persistence.*;

@Entity
@Table(name="lists")
public class List {
    @Id
    @Column(name="list_id")
    private Integer listId;

    @Column(name="title_id")
    private Integer titleId;

    @Column(name="list")
    private String listName;

    @Column(name="boolean")
    private Integer bool;

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public Integer getBool() {
        return bool;
    }

    public void setBool(Integer bool) {
        this.bool = bool;
    }
}
