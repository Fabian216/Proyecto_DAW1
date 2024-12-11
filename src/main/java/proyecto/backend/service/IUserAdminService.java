package proyecto.backend.service;

import proyecto.backend.dto.UserAdminDto;
import proyecto.backend.entity.UserAdmin;

import java.util.List;

public interface IUserAdminService {
    List<UserAdminDto> getAll();
}
