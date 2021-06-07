package com.challenge.display.jobs.displayjobs.repositories;

import com.challenge.display.jobs.displayjobs.dao.Applicant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    @EntityGraph(attributePaths = "appliedJobs")
    Applicant findByApplicantName(@Param("applicant_name") String name);
}
