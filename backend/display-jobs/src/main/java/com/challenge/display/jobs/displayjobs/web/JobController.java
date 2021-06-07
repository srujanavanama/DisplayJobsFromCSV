package com.challenge.display.jobs.displayjobs.web;

import com.challenge.display.jobs.displayjobs.dao.Applicant;
import com.challenge.display.jobs.displayjobs.dao.Job;
import com.challenge.display.jobs.displayjobs.service.ApplicantService;
import com.challenge.display.jobs.displayjobs.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(path = "/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicantService applicantService;

    public JobController(JobService jobService, ApplicantService applicantService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
    }

    protected JobController() {
    }

    @GetMapping
    public List<JobDto> getAllJobs() {
        List<Job> allJobs = jobService.lookupAll();
        List<JobDto> jobDtoList = allJobs.stream().map(job -> toJobDto(job)).collect(Collectors.toList());
        return jobDtoList;
    }

    @GetMapping(path = "/{jobId}")
    public DetailedJobDto getJobDetails(@PathVariable("jobId") Integer jobId) {
        Job job = jobService.lookupJob(jobId);
        DetailedJobDto detailedJobDto = toDetailedJobDto(job);
        return detailedJobDto;
    }

    private JobDto toJobDto(Job job) {
        return new JobDto(job.getJobId(), job.getJobTitle(), job.getLocation(), job.getDate());
    }

    private DetailedJobDto toDetailedJobDto(Job job) {
        List<String> applicantNames = job.getJobApplicants().stream().map(Applicant::getApplicantName).collect(Collectors.toList());
        return new DetailedJobDto(job.getJobId(), job.getJobTitle(), job.getJobDescription(), job.getLocation(), job.getDate(), applicantNames);
    }

}
