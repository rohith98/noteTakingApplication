package com.app.note.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="titles")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="title_id")
    private Integer titleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group_id")
    private Group group;

    @Column(name="title_name")
    private String titleName;
    
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "title_id")
    private List<Note> notes;

    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
    @JoinColumn(name = "title_id")
    private List<CheckList> lists;

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
