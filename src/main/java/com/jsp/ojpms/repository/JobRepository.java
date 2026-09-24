package com.jsp.ojpms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jsp.ojpms.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

	List<Job> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrLocationContainingIgnoreCase(
			String title, String description, String location);

	List<Job> findByRecruiterId(int recruiterId);

	int countByRecruiterId(int recruiterId);

}