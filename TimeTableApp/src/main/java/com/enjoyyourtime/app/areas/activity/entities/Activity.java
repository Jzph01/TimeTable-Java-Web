package com.enjoyyourtime.app.areas.activity.entities;

import com.enjoyyourtime.app.areas.user.entities.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String link;

    private String info;

    private Date expirationDate;

    private User editor;

    @ManyToOne()
    @JoinColumn(name = "editor_id", nullable = false)
    public User getEditor() {
        return this.editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
