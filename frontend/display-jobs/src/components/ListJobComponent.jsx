import React, { useEffect, useState } from 'react';
import moment from 'moment';
import Button from 'react-bootstrap/Button';
import Table from 'react-bootstrap/Table';
import JobService from './../api/JobService';

const ListJobComponent = (props) => {
    
    const [jobList, setJobList] = useState([]);

    useEffect(() => {
        retrieveAllJobs();
    });

    const retrieveAllJobs = async () => {
        const response = await JobService.get('/jobs');
        setJobList(response.data);
    }

    const retrieveJobDetailsClicked = (jobId) => {
        props.history.push(`/jobs/${jobId}`);
    }

    return (
        <div className="text-center">
            <h1>List of Jobs</h1>
            <div className="container">
                <Table bordered hover>
                    <thead>
                        <tr>
                            <th>Title</th>
                            <th>Location</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        { jobList && 
                            jobList.map(
                                job => 
                                    <tr key={job.jobId}>
                                        <td><Button variant="link" onClick={() => retrieveJobDetailsClicked(job.jobId)} block>{job.jobTitle}</Button></td>
                                        <td>{job.location}</td>
                                        <td>{moment(job.date).format('DD/MM/YYYY')}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </Table>
            </div>
        </div>
    );
}

export default ListJobComponent;