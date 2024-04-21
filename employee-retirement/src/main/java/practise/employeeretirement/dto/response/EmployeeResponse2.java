package practise.employeeretirement.dto.response;

import java.math.BigDecimal;

public record EmployeeResponse2(
        Long empId,
        String firstName,
        String lastName,
        BigDecimal yearlySalary
) {
}
