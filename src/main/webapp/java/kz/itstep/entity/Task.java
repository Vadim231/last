package kz.itstep.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Task extends Entity {
    private String title;
    private String description;
    private Date date;
    private int userId;
    private int projectId;

    public Task(String title, String description, Date date, int userId, int projectId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
        this.projectId = projectId;
    }

    public Task(){}

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title;}

    public String getDescription() { return description; }

    public void setDescription(String description) {this.description = description; }

    public Date getDate() { return date; }

    public void setDate(Date date) {this.date = date;}

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getProjectId() { return projectId;}

    public void setProjectId(int projectId) {  this.projectId = projectId;}
}