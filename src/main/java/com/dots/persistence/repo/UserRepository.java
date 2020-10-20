package com.dots.persistence.repo;

import com.dots.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;
import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    String addUser(@Valid User user, BindingResult result, Model model);

    String updateUser(@PathVariable long id, @Valid User user, BindingResult result, Model model);

    String deleteUser(@PathVariable long id, Model model);

    Iterable<User> findAll();

    User findOne(@PathVariable long id);

    List<User> findByUsername(String username);
}
