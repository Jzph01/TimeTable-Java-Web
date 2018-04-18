package com.enjoyyourtime.app.areas.activity.models.bindingModels;

import com.enjoyyourtime.app.areas.activity.customValidations.PresentOrFuture;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.util.Date;

public class AddActivityBindingModel {

    @Size(min = 3, max = 30, message = "Title Should Be Minimum 3 Maximum 30 characters!")
    private String title;
    @Size(min = 3, max = 30, message = "Link Should Be Minimum 3 Maximum 30 characters!")
    private String link;
    @Size(min = 3, max = 10000, message = "Info Should Be Minimum 3 Maximum 10000 characters!")
    private String info;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PresentOrFuture(message = "The expiration date should be in a future moment")
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
