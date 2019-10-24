package com.app.note.response;

public class CheckListResponse {
    private Integer listId;

    private String listName;

    private Integer checkBox;

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

    public Integer getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Integer checkBox) {
        this.checkBox = checkBox;
    }
}
