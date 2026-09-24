package com.jsp.ojpms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepository jobRepository;

	@Override
	public void saveJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	@Override
	public List<Job> searchJobs(String keyword) {

		return jobRepository
				.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(keyword,
						keyword, keyword);
	}

	@Override
	public List<Job> getJobsByRecruiter(int recruiterId) {
		return jobRepository.findByRecruiterId(recruiterId);
	}

	@Override
	public Job getJobById(int id) {
		return jobRepository.findById(id).orElse(null);
	}

	@Override
	public void updateJob(Job job) {
		jobRepository.save(job);
	}

	@Override
	public int getJobCountByRecruiter(int recruiterId) {
		return jobRepository.countByRecruiterId(recruiterId);
	}

	@Override
	public List<Job> getSearchedJob(String search) {
		return jobRepository
				.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(search,
						search, search);
	}

}