package practise.employeeretirement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import practise.employeeretirement.dto.response.RetirementPlanResponse2;
import practise.employeeretirement.model.RetirementPlan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RetirementPlanRepository extends JpaRepository<RetirementPlan, Long> {

    List<RetirementPlan> findByRetirementDateBetweenOrderByRetirementDateAsc(LocalDate start, LocalDate end);

}
