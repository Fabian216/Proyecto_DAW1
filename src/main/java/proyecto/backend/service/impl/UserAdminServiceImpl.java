package proyecto.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.backend.dto.UserAdminDto;
import proyecto.backend.entity.UserAdmin;
import proyecto.backend.repository.UserAdminRepository;
import proyecto.backend.service.IUserAdminService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAdminServiceImpl implements IUserAdminService {

    @Autowired
    UserAdminRepository userAdminRepository;

    @Override
    public List<UserAdminDto> getAll() {

        List<UserAdminDto> userAdmins = new ArrayList<UserAdminDto>();
        Iterable<UserAdmin> iterable = userAdminRepository.findAll();
        iterable.forEach(userAdmin -> {
            UserAdminDto userAdminDto = new UserAdminDto(userAdmin.getId(),
                    userAdmin.getNombre(),
                    userAdmin.getApellido());
            userAdmins.add(userAdminDto);
        });
        return userAdmins;

    }

}
