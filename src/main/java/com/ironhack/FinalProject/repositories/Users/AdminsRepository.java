package com.ironhack.FinalProject.repositories.Users;

import com.ironhack.FinalProject.models.Users.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins,Long> {
}
