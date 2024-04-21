package practise.employeeretirement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RetirementPlanResponse(
        Long planId,
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        BigDecimal monthlyContribution


) {
}
