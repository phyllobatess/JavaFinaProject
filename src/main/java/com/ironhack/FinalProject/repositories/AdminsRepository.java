package com.ironhack.FinalProject.repositories;

import com.ironhack.FinalProject.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins,Long> {
}
