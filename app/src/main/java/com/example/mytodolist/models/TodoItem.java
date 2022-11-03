package com.example.mytodolist.models;

public class TodoItem {
    private String title;
    private String body;
    private int priority;
    private String dueDate;
    private int Status;

    public TodoItem(String title, String body, int priority, String dueDate, int status) {
        this.title = title;
        this.body = body;
        this.priority = priority;
        this.dueDate = dueDate;
        Status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public int getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public int getStatus() {
        return Status;
    }
}
