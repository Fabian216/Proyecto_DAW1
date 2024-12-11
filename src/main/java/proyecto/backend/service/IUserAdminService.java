package proyecto.backend.service;

import proyecto.backend.dto.UserAdminDto;

import java.util.List;

public interface IUserAdminService {
    List<UserAdminDto> getAll();

    UserAdminDto authenticate(String user, String password);
}
