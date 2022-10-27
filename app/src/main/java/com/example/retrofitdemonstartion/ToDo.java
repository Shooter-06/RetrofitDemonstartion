package com.example.retrofitdemonstartion;

public class ToDo {
    private int id;
    private int userId;
    private String title;
    private boolean complete;

    public ToDo(int id, int userId, String title, boolean complete) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", complete=" + complete +
                '}';
    }
}
