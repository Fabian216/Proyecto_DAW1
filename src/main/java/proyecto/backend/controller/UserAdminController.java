package proyecto.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.backend.dto.UserAdminDto;
import proyecto.backend.service.IUserAdminService;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UserAdminController {

    @Autowired
    IUserAdminService userAdminService;

    @GetMapping("/start")
    public String start(Model model) {
        try {
            List<UserAdminDto> users = userAdminService.getAll();
            model.addAttribute("users", users);
            model.addAttribute("error", "");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Ocurrio un error al obtener los datos");
        }
        return "manage";
    }


    /*@GetMapping
    public List<UserAdminDto> getAllUserAdmins() {
        return userAdminService.getAll();
    }*/


}
