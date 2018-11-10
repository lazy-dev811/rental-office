package szbd.projekt.projektbazy.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import szbd.projekt.projektbazy.rentalOffice.RentalOffice;


	
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(method=RequestMethod.GET,value="/rentalOffice/{idRentalOffice}/employees")
	public List<Employee> getAllEmployees(@PathVariable Integer idRentalOffice)
	{
	  return employeeService.getAllEmployees();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/rentalOffice/{idRentalOffice}/employees/{idEmployee}")
	public Optional<Employee> getEmployee(@PathVariable Integer idEmployee) {
		return employeeService.getEmployee(idEmployee);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/rentalOffice/{idRentalOffice}/employees/")
	public void addEmployee(@RequestBody Employee employee, @PathVariable Integer idRentalOffice) {
		employee.setRentalOffice(new RentalOffice(idRentalOffice, ""));
		employeeService.addEmployee(employee);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/rentalOffice/{idRentalOffice}/employees/{idEmployee}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable Integer idEmployee,
			@PathVariable Integer idRentalOffice)
	{
		employee.setRentalOffice(new RentalOffice(idRentalOffice,""));
		employeeService.updateEmployee(idEmployee, employee);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/rentalOffice/{idRentalOffice}/employees/{idEmployee}")
	public void deleteEmployee(@PathVariable Integer idEmployee)
	{
		 employeeService.deleteEmployee(idEmployee);
	}
	
	
	
	
	
}
