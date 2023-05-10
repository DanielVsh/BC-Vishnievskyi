package danielvishnievskyi.bachelorproject.services.role;

import danielvishnievskyi.bachelorproject.entities.Privilege;
import danielvishnievskyi.bachelorproject.entities.Role;
import danielvishnievskyi.bachelorproject.repositories.RoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
  private final RoleRepo roleRepo;

  @Transactional
  @Override
  public Role createIfNotFound(String name, Set<Privilege> privileges) {
    return roleRepo.getByName(name.toUpperCase()).orElseGet(() -> {
      Role role = new Role(name.toUpperCase());
      role.setPrivileges(privileges);
      roleRepo.save(role);
      return role;
    });
  }
}