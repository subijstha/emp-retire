package practise.employeeretirement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RetirementPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    @Column(nullable = false, unique = true)
    private String referenceNumber;
    @Column(nullable = false)
    private LocalDate enrollmentDate;
    @Column(nullable = false)
    private LocalDate retirementDate;
    private BigDecimal monthlyContribution;
    @OneToOne
    @JoinColumn(name = "employee_Id", nullable = false)
    private Employee employee;



}


