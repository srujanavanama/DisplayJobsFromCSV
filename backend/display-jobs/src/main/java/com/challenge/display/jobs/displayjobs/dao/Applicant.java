package com.challenge.display.jobs.displayjobs.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Integer applicantId;

    @Column(name = "applicant_name")
    private String applicantName;

    @ManyToMany(mappedBy = "jobApplicants")
    private Set<Job> appliedJobs = new HashSet<>();

    public Applicant(String applicantName) {
        this.applicantName = applicantName;
    }

    protected Applicant() {

    }

    public Integer getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Integer applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public Set<Job> getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(Set<Job> appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applicant)) return false;
        Applicant applicant = (Applicant) o;
        return Objects.equals(applicantId, applicant.applicantId) &&
                Objects.equals(applicantName, applicant.applicantName) &&
                Objects.equals(appliedJobs, applicant.appliedJobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicantId, applicantName);
    }
}
