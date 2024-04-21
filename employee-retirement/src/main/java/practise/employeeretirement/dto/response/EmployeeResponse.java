package practise.employeeretirement.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record EmployeeResponse(
    Long empId,
    String firstName,
    String lastName,
    BigDecimal yearlySalary,
    RetirementPlanResponse retirementPlanResponse
) {
}
