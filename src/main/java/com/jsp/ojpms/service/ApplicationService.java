package com.jsp.ojpms.service;

import java.util.List;

import com.jsp.ojpms.entity.Application;

public interface ApplicationService {

    void saveApplication(Application application);

    boolean isAlreadyApplied(int userId, int jobId);

    List<Application> getApplicationsByUser(int userId);

    List<Application> getAllApplications();

    int getApplicationCountByUser(int userId);

    int getApplicationCountForRecruiter(int recruiterId);

}
