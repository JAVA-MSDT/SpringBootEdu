package com.msdt.springmvc.repository;

import java.util.List;

import com.msdt.springmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username=username AND u.password=password")
    public List<User> getUserByLoginCred(@Param("username") String username, @Param("password") String password);
}
