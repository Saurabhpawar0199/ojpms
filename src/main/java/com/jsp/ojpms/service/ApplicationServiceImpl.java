package com.jsp.ojpms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.repository.ApplicationRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public void saveApplication(Application application) {
		applicationRepository.save(application);
	}

	@Override
	public boolean isAlreadyApplied(int userId, int jobId) {
		return applicationRepository.findByUserIdAndJobId(userId, jobId).isPresent();
	}

	@Override
	public List<Application> getApplicationsByUser(int userId) {
		return applicationRepository.findByUserId(userId);
	}

	@Override
	public List<Application> getAllApplications() {
		return applicationRepository.findAll();
	}

	@Override
	public int getApplicationCountByUser(int userId) {
		return applicationRepository.countByUserId(userId);
	}

	@Override
	public int getApplicationCountForRecruiter(int recruiterId) {
		return applicationRepository.countByJobRecruiterId(recruiterId);
	}

}