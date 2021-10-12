package com.MBProject.SpringJpa.service;

import com.MBProject.SpringJpa.dto.OrderResponse;
import com.MBProject.SpringJpa.model.User;
import com.MBProject.SpringJpa.repository.ProductRepository;
import com.MBProject.SpringJpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

   // @PostConstruct
    public void initDB()
    {
        userRepository.save(new User("Mahes1","55 Woodland"));
        userRepository.save(new User("Mahes2","55 Woodland"));
        userRepository.save(new User("Mahes3","55 Woodland"));
        userRepository.save(new User("Mahes4","55 Woodland"));
        userRepository.save(new User("Mahes5","55 Woodland"));
        userRepository.save(new User("Mahes6","55 Woodland"));
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(int userId) {
        return userRepository.getById(userId);
    }

    public List<User> findUserListByMultiConditions(int id, String name)
    {
        return userRepository.findByIdAndName(id, name);
    }

    public List<User> findUserListByNameIgnoreCase(String name)
    {
        return userRepository.findByNameIgnoreCase( name);
    }

    public List<User> getUserSortByName(String field)
    {
        return userRepository.findAll( Sort.by(Sort.Direction.DESC, field));
    }
    public Page<User> getPaginatedUser()
    {
        return userRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.DESC, "name")));
    }

    public List<User> findUserByCustomQuery()
    {
        return userRepository.findByCustomQuery();
    }

    public List<OrderResponse> getJoinInformation(){
        return  userRepository.getJoinInformation();
    }
}
