package com.example.testingweb.validatingforminput;

public class Study {

    private StudyStatus status;

    private int limit;

    private String name;

    public Study(int limit, String name) {
        this.limit = limit;
        this.name = name;
    }

    public Study(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public StudyStatus getStatus() {
        return this.status;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Study{" +
                "status=" + status +
                ", limit=" + limit +
                ", name='" + name + '\'' +
                '}';
    }
}
