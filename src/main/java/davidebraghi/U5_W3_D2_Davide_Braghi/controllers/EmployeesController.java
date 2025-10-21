package davidebraghi.U5_W3_D2_Davide_Braghi.controllers;


import davidebraghi.U5_W3_D2_Davide_Braghi.entities.Employee;
import davidebraghi.U5_W3_D2_Davide_Braghi.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
    @Autowired
    EmployeesService employeesService;

    // GET http://localhost:3001/employees

    @GetMapping("")
    public Page<Employee> getEmployees(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size,
                                       @RequestParam(defaultValue = "id") String sortBy) {
        return employeesService.getEmployees(page, size, sortBy);
    }

    // GET http://localhost:3001/employees/{id}

    @GetMapping("/{employeeId}")
    public Employee findById(@PathVariable long employeeId) {
        return employeesService.findById(employeeId);
    }

    // PUT http://localhost:3001/employees/{id} (+ body)

    @PutMapping("/{employeeId}")
    public Employee findByIdAndUpdate(@PathVariable long employeeId,
                                      @RequestBody Employee body) {
        return employeesService.findByIdAndUpdate(employeeId, body);
    }

    // DELETE http://localhost:3001/employees/{id}

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long employeeId) {
        employeesService.findByIdAndDelete(employeeId);
    }
}