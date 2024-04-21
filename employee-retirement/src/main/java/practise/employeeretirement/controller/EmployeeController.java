package practise.employeeretirement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practise.employeeretirement.dto.response.EmployeeResponse;
import practise.employeeretirement.service.IEmployeeService;
import practise.employeeretirement.service.IRetirementPlanService;
import practise.employeeretirement.service.impl.EmployeeService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    private IEmployeeService employeeService;
    private IRetirementPlanService retirementPlanService;

    public EmployeeController(IEmployeeService employeeService, IRetirementPlanService iRetirementPlanService){
    this.employeeService = employeeService;
    this.retirementPlanService = iRetirementPlanService;
    }





    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployeeList() {
        List<EmployeeResponse> plans = this.employeeService.getAllEmployeesWithRetirementPlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponse> getPlanByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        EmployeeResponse employeeResponse = employeeService.getRetirementPlanByEmployeeId(employeeId);
        return ResponseEntity.ok(employeeResponse);
    }

    @GetMapping("/upcomingRetirees")
    public ResponseEntity<List<EmployeeResponse>> getUpcomingRetirees() {
        LocalDate firstDayOfNextMonth = LocalDate.now().plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        List<EmployeeResponse> upcomingRetirees = retirementPlanService.getUpcomingRetirees(firstDayOfNextMonth, lastDayOfNextMonth);
        return ResponseEntity.ok(upcomingRetirees);
    }
}