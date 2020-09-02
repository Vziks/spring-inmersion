package info.vziks.api.repository;

import info.vziks.api.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String role);
}
