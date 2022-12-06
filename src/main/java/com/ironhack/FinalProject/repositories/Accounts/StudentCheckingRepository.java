package com.ironhack.FinalProject.repositories.Accounts;

import com.ironhack.FinalProject.models.Accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCheckingRepository extends JpaRepository<StudentChecking,Long> {
}
