package info.vziks.api.service;

import info.vziks.api.model.Role;
import info.vziks.api.model.User;
import info.vziks.api.repository.RoleRepository;
import info.vziks.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class UserService
 * Project spring-api
 *
 * @author Anton Prokhorov <vziks@live.ru>
 */
@Service
public class UserService implements UserDetailsService {

    @PersistenceContext
    private EntityManager entityManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return user;
    }

    public boolean saveUser(User user) {
        User userFromDb =
                userRepository.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }

        Role role = roleRepository.findByName("ROLE_USER");
        user.getRoles().add(role);
        user.setPassword(encoder.encode(user.getPassword()));
        role.getUsers().add(user);
        userRepository.save(user);
        return true;
    }
}