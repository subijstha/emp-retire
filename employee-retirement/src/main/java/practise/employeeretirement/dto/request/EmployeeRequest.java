package practise.employeeretirement.dto.request;

import java.math.BigDecimal;

public record EmployeeRequest(
        String firstName,
        String lastName,
        BigDecimal yearlySalary
) {
}
