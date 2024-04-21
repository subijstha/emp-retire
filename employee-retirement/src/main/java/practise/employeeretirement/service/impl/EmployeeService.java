package practise.employeeretirement.service.impl;

import jakarta.persistence.Entity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import practise.employeeretirement.dto.response.EmployeeResponse;
import practise.employeeretirement.dto.response.RetirementPlanResponse;
import practise.employeeretirement.exception.ResourceNotFoundException;
import practise.employeeretirement.model.Employee;
import practise.employeeretirement.model.RetirementPlan;
import practise.employeeretirement.repo.EmployeeRepository;
import practise.employeeretirement.service.IEmployeeService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


//    @Override
//    public List<EmployeeResponse> getAllEmployees() {
//        return employeeRepository.findAll(Sort.by("lastName"))
//                .stream()
//                .map(employee -> new EmployeeResponse(
//                        employee.getEmpId(),
//                        employee.getFirstName(),
//                        employee.getLastName(),
//                        employee.getYearlySalary(),
//                        mapRetirementPlansToResponses(employee.getRetirementPlanList())
//                ))
//                .toList();
//    }
//
//    private List<RetirementPlanResponse> mapRetirementPlansToResponses(List<RetirementPlan> retirementPlans) {
//        if (retirementPlans == null) {
//            return Collections.emptyList();
//        }
//        return retirementPlans.stream()
//                .map(retirementPlan -> new RetirementPlanResponse(
//                        retirementPlan.getPlanId(),
//                        retirementPlan.getReferenceNumber(),
//                        retirementPlan.getEnrollmentDate(),
//                        retirementPlan.getRetirementDate(),
//                        retirementPlan.getMonthlyContribution()
//                ))
//                .toList();
//    }

    @Override
    public Employee addEmployeeWithRetirementPlan(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeResponse> getAllEmployeesWithRetirementPlans() {
        List<Employee> employees = employeeRepository.findAllByOrderByLastNameAsc();
        return employees.stream()
                .map(employee -> {
                    RetirementPlan plan = employee.getRetirementPlan();
                    return new EmployeeResponse(
                            employee.getEmpId(),
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getYearlySalary(),
                            new RetirementPlanResponse(plan.getPlanId(), plan.getReferenceNumber(),
                                    plan.getEnrollmentDate(),
                                    plan.getRetirementDate(),
                                    plan.getMonthlyContribution())

                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getRetirementPlanByEmployeeId(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));
        RetirementPlan plan = employee.getRetirementPlan();
        return new EmployeeResponse(
                employee.getEmpId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getYearlySalary(),
                new RetirementPlanResponse(plan.getPlanId(), plan.getReferenceNumber(),
                        plan.getEnrollmentDate(),
                        plan.getRetirementDate(),
                        plan.getMonthlyContribution())
        );


    }


}
