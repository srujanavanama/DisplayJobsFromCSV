package com.challenge.display.jobs.displayjobs.web;

import java.util.Date;
import java.util.List;

public class DetailedJobDto {
    private Integer jobId;
    private String jobTitle;
    public String jobDescription;
    private String location;
    private Date date;
    private List<String> applicantNames;

    public DetailedJobDto(Integer jobId, String jobTitle, String jobDescription, String location, Date date, List<String> applicantNames) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.location = location;
        this.date = date;
        this.applicantNames = applicantNames;
    }

    protected DetailedJobDto() {}

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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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

    public List<String> getApplicantNames() {
        return applicantNames;
    }

    public void setApplicantNames(List<String> applicantNames) {
        this.applicantNames = applicantNames;
    }
}
