package com.challenge.display.jobs.displayjobs.service;

import com.challenge.display.jobs.displayjobs.dao.Applicant;
import com.challenge.display.jobs.displayjobs.repositories.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    private ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    //returns all the applicants
    public List<Applicant> lookupAll() {
        return applicantRepository.findAll();
    }
}
