package com.jsp.ojpms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.ojpms.entity.Application;
import com.jsp.ojpms.entity.Job;
import com.jsp.ojpms.entity.User;
import com.jsp.ojpms.service.ApplicationService;
import com.jsp.ojpms.service.EmailService;
import com.jsp.ojpms.service.JobService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplyJobController {

	@Autowired
	private JobService jobService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping("/applyjob")
	public String applyJob(@RequestParam int jobId, HttpSession session, Model model) {

		User user = (User) session.getAttribute("user");

		if (user == null) {
			return "redirect:/login";
		}

		Job job = jobService.getJobById(jobId);

		if (applicationService.isAlreadyApplied(user.getId(), jobId)) {

			model.addAttribute("error", "Already Applied for " + job.getTitle());

			List<Job> jobs = jobService.getAllJobs();
			model.addAttribute("jobs", jobs);

			return "viewjob";
		}

		Application application = new Application();
		application.setJob(job);
		application.setUser(user);

		applicationService.saveApplication(application);

		// Email sending will be added later
		emailService.sendEmail(user.getEmail(), "Job Application Submitted",
				"Dear " + user.getName() + ",\n\nYou have successfully applied for the job: " + job.getTitle()
						+ ".\n\nThank you for using OJPMS.");

		return "redirect:/viewjob";
	}
}