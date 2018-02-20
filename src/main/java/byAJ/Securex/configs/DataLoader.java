package byAJ.Securex.configs;


import byAJ.Securex.models.AppRole;
import byAJ.Securex.models.AppRoleRepository;
import byAJ.Securex.models.AppUser;
import byAJ.Securex.models.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//Remove the annotation after you have run this method once in a database that persists to storage.
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    AppRoleRepository roleRepo;

    @Autowired
    AppUserRepository userRepository;


    @Override
    public void run(String... strings) throws Exception {

        //Add all data that should be in the database at the beginning of the application
        AppRole role = new AppRole();
        role.setRoleName("USER");
        roleRepo.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        roleRepo.save(role);




        //Add test data for users

        AppUser user = new AppUser();
        user.setLogintousername("bookworm");
        user.setSecretsecretpassword("password");
        user.setFirstName("Jane");
        user.setLastName("Doe-Schmidt");
        user.addRole(roleRepo.findAppRoleByRoleName("USER"));
        userRepository.save(user);
//        System.out.println(userRepository.findByRoles(roleRepo.findAppRoleByRoleName("USER")));


    }
}
