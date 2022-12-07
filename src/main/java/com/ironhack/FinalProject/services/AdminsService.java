package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.repositories.UserRepositories.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminsService {
    @Autowired
    AdminsRepository adminsRepository;
}
