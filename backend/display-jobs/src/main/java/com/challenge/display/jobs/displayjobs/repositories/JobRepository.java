package com.challenge.display.jobs.displayjobs.repositories;

import com.challenge.display.jobs.displayjobs.dao.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findByJobId(Integer jobId);
}
