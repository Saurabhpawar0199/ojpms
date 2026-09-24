package com.jsp.ojpms.service;

import java.util.List;
import com.jsp.ojpms.entity.Job;

public interface JobService {

	void saveJob(Job job);

	List<Job> getAllJobs();

	List<Job> searchJobs(String keyword);

	List<Job> getSearchedJob(String search);

	List<Job> getJobsByRecruiter(int recruiterId);

	Job getJobById(int id);

	void updateJob(Job job);

	int getJobCountByRecruiter(int recruiterId);

}