package vip.redcode.discount.core.service.serviceimpl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vip.redcode.discount.core.model.User;
import vip.redcode.discount.core.repository.UserRepository;
import vip.redcode.discount.core.service.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository repository;

    private PasswordEncoder encoder;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User savePut(Long id, User user) {
        return repository.findById(id)
                .map(userSave -> {
                    userSave.setId(user.getId());
                    userSave.setPassword(encoder.encode(user.getPassword()));
                    userSave.setFirstName(user.getFirstName());
                    userSave.setLastName(user.getLastName());
                    userSave.setMiddleName(user.getMiddleName());
                    userSave.setDiscounts(user.getDiscounts());
                    return repository.save(userSave);
                }).orElse(null);
    }

    @Override
    public User savePatch(Long id, User user) {
        return repository.findById(id)
                .map(userSave -> {
                    if (user.getPassword() != null)
                        user.setPassword(encoder.encode(user.getPassword()));
                    if (user.getFirstName() != null)
                        userSave.setFirstName(user.getFirstName());
                    if (user.getLastName() != null)
                        userSave.setLastName(user.getLastName());
                    if (user.getMiddleName() != null)
                        userSave.setMiddleName(user.getMiddleName());
                    if (user.getDiscounts() != null)
                        userSave.setDiscounts(user.getDiscounts());
                    return repository.save(userSave);
                }).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        return repository.findByPhoneNumber(phoneNumber);
    }
}
