package com.jeorgius.front.rest.media.paths;

public class FilePath {

    private Content content;
    private boolean TMP = false;
    private String userId = "";
    private String id = "";
    private String index = "";

    public FilePath(){}

    public FilePath setContent(Content content) {
        this.content = content;
        return this;
    }

    public FilePath setTMP(boolean TMP) {
        this.TMP = TMP;
        return this;
    }

    public FilePath setUserId(String userId) {
        this.userId = "\\"+userId;
        return this;
    }

    public FilePath setId(String id) {
        this.id = "\\"+id;
        return this;
    }

    public FilePath setIndex(String index) {
        this.index = "\\"+index;
        return this;
    }

    public String build(){
        return (TMP? "tmp" : "")
            + userId
            + "\\" + content.name().toLowerCase()
            + id
            + index;
    }
}
