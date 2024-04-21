package practise.employeeretirement.service;

import practise.employeeretirement.dto.request.EmployeeRequest;
import practise.employeeretirement.dto.response.EmployeeResponse;
import practise.employeeretirement.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployeeWithRetirementPlan(Employee employee);
    List<EmployeeResponse> getAllEmployeesWithRetirementPlans();
    EmployeeResponse getRetirementPlanByEmployeeId(Long employeeId);

}