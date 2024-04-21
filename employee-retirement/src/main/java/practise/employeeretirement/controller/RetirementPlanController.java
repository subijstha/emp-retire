package practise.employeeretirement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practise.employeeretirement.dto.response.RetirementPlanResponse2;
import practise.employeeretirement.service.IRetirementPlanService;

@RestController
@RequestMapping("api/v1/plan")
public class RetirementPlanController {
    @Autowired
    private IRetirementPlanService retirementPlanService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewRetirementPlan(@RequestBody RetirementPlanResponse2 request) {
        retirementPlanService.addNewRetirementPlan(request);
        return new ResponseEntity<>("New retirement plan added successfully", HttpStatus.CREATED);
    }
}
