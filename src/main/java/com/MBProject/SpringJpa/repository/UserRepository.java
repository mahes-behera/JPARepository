package com.MBProject.SpringJpa.repository;

import com.MBProject.SpringJpa.dto.OrderResponse;
import com.MBProject.SpringJpa.model.User;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> deleteByName(String name);

    public List<User> findByIdAndName(int id, String name);

    public List<User> findByNameIgnoreCase( String name);

    @Query("select u from User u")
    public List<User> findByCustomQuery();


    @Query("SELECT new com.MBProject.SpringJpa.dto.OrderResponse(c.name, p.productName) from User c JOIN c.products p")
    public List<OrderResponse> getJoinInformation();
}
