package com.ironhack.FinalProject.repositories;

import com.ironhack.FinalProject.models.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking,Long> {
}
