package practise.employeeretirement.service;

import practise.employeeretirement.dto.response.EmployeeResponse;
import practise.employeeretirement.dto.response.RetirementPlanResponse2;

import java.time.LocalDate;
import java.util.List;

public interface IRetirementPlanService {
    List<EmployeeResponse> getUpcomingRetirees(LocalDate startDate, LocalDate endDate);
    void addNewRetirementPlan(RetirementPlanResponse2 request);
}
