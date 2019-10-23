package com.app.note.response;

public class CheckListResponse {
    private String listName;

    private Integer bool;

    private Integer listId;

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
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
