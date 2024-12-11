package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import proyecto.backend.dto.UserAdminDto;
import proyecto.backend.service.IUserAdminService;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UserAdminController {

    @Autowired
    IUserAdminService userAdminService;

    // Mostrar la página de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Nombre de la plantilla de Thymeleaf
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String login(
            @RequestParam("user") String user,
            @RequestParam("password") String password,
            Model model
    ) {
        try {
            // Autenticar al usuario
            UserAdminDto authenticatedUser = userAdminService.authenticate(user, password);

            // Si las credenciales son correctas, redirigir a una página de éxito
            model.addAttribute("user", authenticatedUser);
            return "dashboard"; // Nombre de la plantilla de éxito
        } catch (RuntimeException e) {
            // Si las credenciales son incorrectas, devolver al login con un mensaje de error
            model.addAttribute("error", "Credenciales inválidas. Inténtalo nuevamente.");
            return "login";
        }
    }

}
