package practise.employeeretirement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RetirementPlanResponse2(
        String firstName,
        String lastName,
        BigDecimal yearlySalary,
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        BigDecimal monthlyContribution
) {
}
