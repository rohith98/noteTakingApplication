package com.app.note.request;

public class CheckListRequest {
    private Integer listId;

    private Integer titleId;

    private String listName;

    private Integer checkBox;

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

    public Integer getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(Integer checkBox) {
        this.checkBox = checkBox;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }
}
