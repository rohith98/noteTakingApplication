package com.app.note.entity;

import javax.persistence.*;

@Entity
@Table(name="lists")
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="list_id")
    private Integer listId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="title_id")
    private Title title;

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

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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
