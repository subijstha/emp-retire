package practise.employeeretirement.service.impl;

import org.springframework.stereotype.Service;
import practise.employeeretirement.dto.response.EmployeeResponse;
import practise.employeeretirement.dto.response.RetirementPlanResponse;
import practise.employeeretirement.dto.response.RetirementPlanResponse2;
import practise.employeeretirement.model.Employee;
import practise.employeeretirement.model.RetirementPlan;
import practise.employeeretirement.repo.EmployeeRepository;
import practise.employeeretirement.repo.RetirementPlanRepository;
import practise.employeeretirement.service.IRetirementPlanService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RetirementPlanService implements IRetirementPlanService {



    private RetirementPlanRepository retirementPlanRepository;
    private EmployeeRepository employeeRepository;

    public RetirementPlanService(RetirementPlanRepository retirementPlanRepository, EmployeeRepository employeeRepository){
        this.retirementPlanRepository = retirementPlanRepository;
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeResponse> getUpcomingRetirees(LocalDate startDate, LocalDate endDate) {
        List<RetirementPlan> upcomingRetirementPlans = retirementPlanRepository.findByRetirementDateBetweenOrderByRetirementDateAsc(startDate, endDate);
        return upcomingRetirementPlans.stream()
                .map(plan -> {
                    return new EmployeeResponse(
                            plan.getEmployee().getEmpId(),
                            plan.getEmployee().getFirstName(),
                            plan.getEmployee().getLastName(),
                            plan.getEmployee().getYearlySalary(),
                            new RetirementPlanResponse(plan.getPlanId(), plan.getReferenceNumber(),
                                    plan.getEnrollmentDate(),
                                    plan.getRetirementDate(),
                                    plan.getMonthlyContribution())
                    );
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addNewRetirementPlan(RetirementPlanResponse2 request) {
        Employee employee = new Employee();
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setYearlySalary(request.yearlySalary());
        employee = employeeRepository.save(employee);

        RetirementPlan retirementPlan = new RetirementPlan();
        retirementPlan.setReferenceNumber(request.referenceNumber());
        retirementPlan.setEnrollmentDate(request.enrollmentDate());
        retirementPlan.setRetirementDate(request.retirementDate());
        retirementPlan.setMonthlyContribution(request.monthlyContribution());
        retirementPlan.setEmployee(employee);
        retirementPlanRepository.save(retirementPlan);
    }
}
