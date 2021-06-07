import React, { useEffect, useState } from "react";
import moment from "moment";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import JobService from "./../api/JobService";

const JobComponent = (props) => {
  const jobId = Number(props.match.params.jobId);

  const [jobDetails, setJobDetails] = useState([]);

  useEffect(() => {
    retrieveJobDetails(jobId);
  });

  const retrieveJobDetails = async (jobId) => {
    const response = await JobService.get(`/jobs/${jobId}`);
    console.log(response.data);
    setJobDetails(response.data);
  };

  const viewJobsListClicked = () => {
    console.log("viewJobsListClicked");
    props.history.push(`/jobs`);
  };

  return (
    <div className="text-center">
        <h3>Job Details</h3>
      <Card border="light" className="center">
        <Card.Body>
          <Card.Title>{jobDetails.jobTitle}</Card.Title>
          <Card.Text>
            <div>{jobDetails.jobDescription}</div>
            <div>{jobDetails.location}</div>
            <div>{moment(jobDetails.date).format("DD/MM/YYYY")}</div>
            <br />
            <h6>Applicants :</h6>
            <div className="flex"> 
                {jobDetails.applicantNames &&
                jobDetails.applicantNames.map((name) => <div>{name}</div>)}
            </div>
          </Card.Text>
        </Card.Body>
        <Card.Body>
        <Button variant="primary" onClick={() => viewJobsListClicked()}>
            Return to Jobs List
        </Button>
        </Card.Body>
      </Card>
    </div>
  );
};

export default JobComponent;