package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.repositories.UserRepositories.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;
}
