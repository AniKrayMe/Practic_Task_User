package com.company.objects;

public class Task {
    private String name;
    private String state;
    private int userID;

    public Task(String name, String state, int userID) {
        this.name = name;
        this.state = state;
        this.userID = userID;
    }

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", userID=" + userID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (userID != task.userID) return false;
        if (name != null ? !name.equals( task.name ) : task.name != null) return false;
        return state != null ? state.equals( task.state ) : task.state == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + userID;
        return result;
    }
}
