package proyecto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.dto.UserAdminDto;
import proyecto.backend.entity.UserAdmin;
import proyecto.backend.repository.UserAdminRepository;
import proyecto.backend.service.IUserAdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAdminServiceImpl implements IUserAdminService {

    private final UserAdminRepository userAdminRepository;

    @Autowired
    public UserAdminServiceImpl(UserAdminRepository userAdminRepository) {
        this.userAdminRepository = userAdminRepository;
    }

    @Override
    public List<UserAdminDto> getAll() {

        List<UserAdminDto> userAdmins = new ArrayList<UserAdminDto>();
        Iterable<UserAdmin> iterable = userAdminRepository.findAll();
        iterable.forEach(userAdmin -> {
            UserAdminDto userAdminDto = new UserAdminDto(userAdmin.getId(),
                    userAdmin.getUser(),
                    userAdmin.getPassword());
            userAdmins.add(userAdminDto);
        });
        return userAdmins;

    }

    @Override
    public UserAdminDto authenticate(String user, String password) {
        // Usar el mét personalizado del repositorio
        Optional<UserAdmin> userAdminOptional = userAdminRepository.findByUserAndPassword(user, password);

        if (userAdminOptional.isPresent()) {
            UserAdmin userAdmin = userAdminOptional.get();
            return new UserAdminDto(userAdmin.getId(), userAdmin.getUser(), userAdmin.getPassword());
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

}
