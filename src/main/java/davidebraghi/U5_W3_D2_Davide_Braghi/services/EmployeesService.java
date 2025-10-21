package davidebraghi.U5_W3_D1_Davide_Braghi.services;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Employee;
import davidebraghi.U5_W3_D1_Davide_Braghi.exceptions.BadRequestException;
import davidebraghi.U5_W3_D1_Davide_Braghi.exceptions.NotFoundException;
import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.Employees.NewEmployeeDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeesService {
    @Autowired
    private EmployeeRepo employeeRepo;

    // Paginazione // findAll

    public Page<Employee> getEmployees(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return employeeRepo.findAll(pageable);
    }

    // findById

    public Employee findById(long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    // Save

    public Employee save(NewEmployeeDTO body) throws IOException {
        if (employeeRepo.findByUsername(body.username()).isPresent()) {
            throw new BadRequestException("The username " + body.username() + " is already in use. Try another username.");
        }

        Employee newEmployee = new Employee();
        newEmployee.setUsername(body.username());
        newEmployee.setSurname(body.surname());
        newEmployee.setName(body.name());
        newEmployee.setEmail(body.email());
        newEmployee.setPassword(body.password());

        return employeeRepo.save(newEmployee);
    }

    // findByIdAndUpdate

    public Employee findByIdAndUpdate(long id, Employee body) {
        Employee found = this.findById(id);
        found.setUsername(body.getUsername());
        found.setSurname(body.getSurname());
        found.setName(body.getName());
        found.setEmail(body.getEmail());
        found.setPassword(body.getPassword());

        return employeeRepo.save(found);
    }

    // findByIdAndDelete

    public void findByIdAndDelete(long id) {
        Employee found = this.findById(id);
        employeeRepo.delete(found);
    }

    public Employee findByEmail(String email) {
        return this.employeeRepo.findByEmail(email).orElseThrow(() -> new NotFoundException("User with e-mail: " + email + " was not found."));
    }
}