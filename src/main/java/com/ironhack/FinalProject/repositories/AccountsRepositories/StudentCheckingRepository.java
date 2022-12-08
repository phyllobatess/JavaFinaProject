package com.ironhack.FinalProject.repositories.AccountsRepositories;

import com.ironhack.FinalProject.models.Accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking,Long> {
}
