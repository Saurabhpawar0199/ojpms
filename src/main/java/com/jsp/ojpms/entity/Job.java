package com.jsp.ojpms.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	private String location;
	private double salary;

	@ManyToOne
	@JoinColumn(name = "recruiter_id")
	private User recruiter;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(String title, String description, String location, double salary, User recruiter) {
		super();

		this.title = title;
		this.description = description;
		this.location = location;
		this.salary = salary;
		this.recruiter = recruiter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public User getRecuriter() {
		return recruiter;
	}

	public void setRecuriter(User recruiter) {
		this.recruiter = recruiter;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", salary=" + salary + ", recuriter=" + recruiter + "]";
	}

}