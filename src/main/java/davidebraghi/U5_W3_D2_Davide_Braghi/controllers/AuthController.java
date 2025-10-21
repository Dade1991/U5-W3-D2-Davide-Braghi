package davidebraghi.U5_W3_D2_Davide_Braghi.controllers;

import davidebraghi.U5_W3_D2_Davide_Braghi.entities.Employee;
import davidebraghi.U5_W3_D2_Davide_Braghi.exceptions.BadRequestException;
import davidebraghi.U5_W3_D2_Davide_Braghi.payloads.BusinessTrips.NewBusinessTripResponseDTO;
import davidebraghi.U5_W3_D2_Davide_Braghi.payloads.Employees.NewEmployeeDTO;
import davidebraghi.U5_W3_D2_Davide_Braghi.payloads.LoginDTO;
import davidebraghi.U5_W3_D2_Davide_Braghi.payloads.LoginResponseDTO;
import davidebraghi.U5_W3_D2_Davide_Braghi.services.AuthService;
import davidebraghi.U5_W3_D2_Davide_Braghi.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    EmployeesService employeesService;
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO body) {
        return new LoginResponseDTO(authService.checkCredentialAndGenerateToken(body));
    }

    // POST http://localhost:3001/employees (+ body)

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public NewBusinessTripResponseDTO saveEmployee(@RequestBody @Validated NewEmployeeDTO body,
                                                   BindingResult validation)
            throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Employee newEmployee = employeesService.save(body);
        return new NewBusinessTripResponseDTO(newEmployee.getId());
    }
}
