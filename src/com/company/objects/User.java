package com.company.objects;

public class User {
    private String name;
    private String sureName;

    public User(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals( user.name ) : user.name != null) return false;
        return sureName != null ? sureName.equals( user.sureName ) : user.sureName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sureName != null ? sureName.hashCode() : 0);
        return result;
    }
}
