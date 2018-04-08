package com.enjoyyourtime.app.models.bindingModels;

import javax.validation.constraints.Size;
import java.util.Date;

public class ActivityBindingModel {

    @Size(min = 3, max = 30, message = "Title Should Be Minimum 3 Maximum 30 characters!")
    private String title;
    @Size(min = 3, max = 30, message = "Link Should Be Minimum 3 Maximum 30 characters!")
    private String link;

    private String info;

    private Date expirationDate;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
