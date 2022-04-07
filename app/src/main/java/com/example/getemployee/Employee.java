package com.example.getemployee;

import java.io.Serializable;

public class Employee implements Serializable {

    private int pic;
    private String name;
    private String status;
    private String applied;
    private String reviewed;
    private String contacted;

    public Employee(int pic, String name, String status, String applied, String reviewed, String contacted) {
        this.pic = pic;
        this.name = name;
        this.status = status;
        this.applied = applied;
        this.reviewed = reviewed;
        this.contacted = contacted;
    }
    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplied() {
        return applied;
    }

    public void setApplied(String applied) {
        this.applied = applied;
    }

    public String getReviewed() {
        return reviewed;
    }

    public void setReviewed(String reviewed) {
        this.reviewed = reviewed;
    }

    public String getContacted() {
        return contacted;
    }

    public void setContacted(String contacted) {
        this.contacted = contacted;
    }

}
