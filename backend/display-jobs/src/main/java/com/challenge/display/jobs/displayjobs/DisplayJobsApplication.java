package com.challenge.display.jobs.displayjobs;

import com.challenge.display.jobs.displayjobs.dao.Applicant;
import com.challenge.display.jobs.displayjobs.service.ApplicantService;
import com.challenge.display.jobs.displayjobs.service.JobService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class DisplayJobsApplication implements CommandLineRunner {

	@Autowired
	private ApplicantService applicantService;

	@Autowired
	private JobService jobService;

	public static void main(String[] args) {
		SpringApplication.run(DisplayJobsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		readCSV();
	}

	public void readCSV() throws IOException, ParseException {
		Reader in = new FileReader("F:/jobs.csv");
		String[] HEADERS = { "job title", "job description", "date", "location", "applicants"};
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			String job_title = record.get("job title");
			String job_description = record.get("job description");
			Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(record.get("date"));
			String location = record.get("location");
			String applicantsRecord = record.get("applicants").replace(" ", "");
			List<String> applicantsNameList = Stream.of(applicantsRecord.split(",", -1)).collect(Collectors.toList());
			jobService.createJob(job_title, job_description, date, location, applicantsNameList);
		}
	}
}
