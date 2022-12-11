package com.ironhack.FinalProject.repositories.UserRepositories;

import com.ironhack.FinalProject.models.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
