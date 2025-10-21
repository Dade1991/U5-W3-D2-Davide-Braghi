package davidebraghi.U5_W3_D1_Davide_Braghi.services;

import davidebraghi.U5_W3_D1_Davide_Braghi.entities.Employee;
import davidebraghi.U5_W3_D1_Davide_Braghi.exceptions.UnauthorizedException;
import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.LoginDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private JWTTools jwtTools;

    public String checkCredentialAndGenerateToken(LoginDTO body) {
        Employee found = this.employeesService.findByEmail(body.email());
        if (found.getPassword().equals(body.password())) {
            return jwtTools.createToken(found);
        } else {
            throw new UnauthorizedException("Wrong credentials.");
        }
    }
}
