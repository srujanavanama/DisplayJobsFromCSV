import React from "react";
import Button from "react-bootstrap/Button";

const WelcomeComponent = (props) => {
  const viewJobsListClicked = () => {
    console.log("viewJobsListClicked");
    props.history.push(`/jobs`);
  };

  return (
    <div className="container text-center">
      <h1>Welcome to Jobs Display Application</h1>
      <br />
      <h4>
        In our application, We have different jobs and each job has different applicants
      </h4>
      <br />
      <div className="container">
        To view all the jobs click the below button. To view additional
        details of a particular job, please click on the job's title in next page.
      </div>
      <br />
      <Button variant="primary" onClick={() => viewJobsListClicked()}>
        View Jobs List
      </Button>
    </div>
  );
};

export default WelcomeComponent;
