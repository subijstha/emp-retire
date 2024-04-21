package practise.employeeretirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import practise.employeeretirement.dto.request.EmployeeRequest;
import practise.employeeretirement.model.Employee;
import practise.employeeretirement.model.RetirementPlan;
import practise.employeeretirement.repo.EmployeeRepository;
import practise.employeeretirement.repo.RetirementPlanRepository;
import practise.employeeretirement.service.IEmployeeService;
import practise.employeeretirement.service.impl.EmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeRetirementApplication implements CommandLineRunner {

	@Autowired
	private  EmployeeRepository employeeRepository;
	@Autowired
	private RetirementPlanRepository retirementPlanRepository;
	@Autowired
	private IEmployeeService employeeService ;


	public static void main(String[] args) {
		SpringApplication.run(EmployeeRetirementApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		loadEmployee();
//		loadRetirementPlan();


	}

//	private void loadEmployee() {
//		List<Employee> employees = new ArrayList<>();
//		employees.add(new Employee("Daniel", "Agar", new BigDecimal("105945.50")));
//		employees.add(new Employee("Benard", "Shaw", new BigDecimal("197750.00")));
//		employees.add(new Employee("Carly", "DeFiori", new BigDecimal("842000.75")));
//		employees.add(new Employee("Wesley", "Schneider", new BigDecimal("74500.00")));
//
//
//		List<RetirementPlan> retirementPlans = List.of(  new RetirementPlan("EX1089", LocalDate.parse("2022-01-17"), LocalDate.parse("2023-09-13"), new BigDecimal("100.00")),
//				new RetirementPlan("SM1104", LocalDate.parse("2023-02-20"), LocalDate.parse("2023-09-21"), new BigDecimal("950.00")),
//				new RetirementPlan("SM2307", LocalDate.parse("2020-05-16"), LocalDate.parse("2023-11-04"), new BigDecimal("1555.50")),
//				new RetirementPlan("SM4133", LocalDate.parse("2019-12-01"), LocalDate.parse("2023-09-30"), new BigDecimal("85.00")));
//
//
//		for(int i=0; i<employees.size(); i++){
//			Employee employee = employees.get(i);
//			RetirementPlan retirementPlan = retirementPlans.get(i);
//			retirementPlan.setEmployee(employee);
//			employee.getRetirementPlanList().add(retirementPlan);
//			employeeRepository.save(employee);
//			retirementPlanRepository.save(retirementPlan);
//
//		}


//	}

	private void loadRetirementPlan() {

	}
}
