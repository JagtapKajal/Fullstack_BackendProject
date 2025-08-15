package com.WebServicesProject.Fullstack_Backend.repository;

import com.WebServicesProject.Fullstack_Backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
