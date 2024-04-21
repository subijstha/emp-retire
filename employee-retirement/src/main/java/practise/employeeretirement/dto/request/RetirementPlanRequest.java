package practise.employeeretirement.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RetirementPlanRequest(
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        BigDecimal monthlyContribution
) {
}
