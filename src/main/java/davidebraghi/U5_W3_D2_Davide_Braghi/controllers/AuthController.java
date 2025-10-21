package davidebraghi.U5_W3_D1_Davide_Braghi.controllers;

import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.LoginDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.payloads.LoginResponseDTO;
import davidebraghi.U5_W3_D1_Davide_Braghi.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginDTO body) {
        return new LoginResponseDTO(authService.checkCredentialAndGenerateToken(body));
    }
}
