package com.challenge.display.jobs.displayjobs.dao;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private Integer jobId;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "job_description")
    private String jobDescription;

    @Column
    private Date date;

    @Column
    private String location;

    @ManyToMany(fetch = FetchType.EAGER)
            @JoinTable(
                    name="job_applicant",
                    joinColumns = @JoinColumn(name = "job_id"),
                    inverseJoinColumns = @JoinColumn(name = "applicant_id")
            )
    private Set<Applicant> jobApplicants;

    public Job(String jobTitle, String jobDescription, Date date, String location, Set<Applicant> jobApplicants) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.date = date;
        this.location = location;
        this.jobApplicants = jobApplicants;
        this.jobApplicants.forEach(applicant -> applicant.getAppliedJobs().add(this));
    }

    protected Job() {

    }

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Applicant> getJobApplicants() {
        return jobApplicants;
    }

    public void setJobApplicants(Set<Applicant> jobApplicants) {
        this.jobApplicants = jobApplicants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return Objects.equals(jobId, job.jobId) &&
                Objects.equals(jobTitle, job.jobTitle) &&
                Objects.equals(jobDescription, job.jobDescription) &&
                Objects.equals(date, job.date) &&
                Objects.equals(location, job.location) &&
                Objects.equals(jobApplicants, job.jobApplicants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobTitle, jobDescription, date, location);
    }
}
