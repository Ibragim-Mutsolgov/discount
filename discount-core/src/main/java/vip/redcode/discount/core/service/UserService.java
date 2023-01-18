package vip.redcode.discount.core.service;

import vip.redcode.discount.core.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User save(User user);

    User savePut(Long id, User user);

    User savePatch(Long id, User user);

    void deleteById(Long id);
}
