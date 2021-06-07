package com.challenge.display.jobs.displayjobs.web;

import java.util.Date;

public class JobDto {

    private Integer jobId;
    private String jobTitle;
    private String location;
    private Date date;

    public JobDto(Integer jobId, String jobTitle, String location, Date date) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.location = location;
        this.date = date;
    }

    protected JobDto() {}

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
