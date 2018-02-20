package byAJ.Securex.models;

import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
    HashSet <AppUser> findByRoles(AppRole r);
}
