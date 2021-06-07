package com.challenge.display.jobs.displayjobs.service;

import com.challenge.display.jobs.displayjobs.dao.Applicant;
import com.challenge.display.jobs.displayjobs.dao.Job;
import com.challenge.display.jobs.displayjobs.repositories.ApplicantRepository;
import com.challenge.display.jobs.displayjobs.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantRepository applicantRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //Creates a job with provided details, sets applicants with the given applicant names, if applicants doesnot exits creates a new applicant
    public Job createJob(String job_title, String job_description, Date date, String location, List<String> applicantsNameList) {
        List<Applicant> jobApplicantsList = new ArrayList<>();
        applicantsNameList.forEach(appliantName -> {
           Applicant applicant = applicantRepository.findByApplicantName(appliantName);
            if(applicant == null) {
                jobApplicantsList.add(applicantRepository.save(new Applicant(appliantName)));
            } else {
                jobApplicantsList.add(applicant);
            }
        });
        Set jobApplicants = Set.copyOf(jobApplicantsList);
        return jobRepository.save(new Job(job_title, job_description, date, location, jobApplicants));
    }

    public List<Job> lookupAll() {
        return jobRepository.findAll();
    }

    public Job lookupJob(Integer jobId) {
        return jobRepository.findByJobId(jobId);
    }
}
