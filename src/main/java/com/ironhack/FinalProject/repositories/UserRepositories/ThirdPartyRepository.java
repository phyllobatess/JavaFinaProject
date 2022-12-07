package com.ironhack.FinalProject.repositories.UserRepositories;

import com.ironhack.FinalProject.models.Users.ThirdParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThirdPartyRepository extends JpaRepository<ThirdParty,Long> {
}
