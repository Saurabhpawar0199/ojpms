package com.jsp.ojpms.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.ojpms.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	Optional<Application> findByUserIdAndJobId(int userId, int jobId);

	List<Application> findByUserId(int userId);

	int countByUserId(int userId);

	int countByJobRecruiterId(int recruiterId);

	boolean existsByUserIdAndJobId(int userId, int jobId);

	@Query("SELECT COUNT(a) FROM Application a WHERE a.user.id=?1")
	int countApplicationsByUser(int userId);

	@Query("SELECT COUNT(a) FROM Application a WHERE a.job.recruiter.id=?1")
	int countApplicationsForRecruiter(int recruiterId);

}