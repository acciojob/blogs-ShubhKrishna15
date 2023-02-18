package com.driver.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Blog")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;

    @CreationTimestamp
    private Date PubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    List<Image> listOfImageInBlog = new ArrayList<>();


    public Blog() {
    }

    public List<Image> getListOfImageInbBlog() {
        return listOfImageInBlog;
    }

    public void setListOfImageInbBlog(List<Image> listOfImageInbBlog) {
        this.listOfImageInBlog = listOfImageInbBlog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return PubDate;
    }

    public void setPubDate(Date pubDate) {
        this.PubDate = pubDate;
    }
}