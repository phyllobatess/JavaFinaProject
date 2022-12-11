package com.ironhack.FinalProject.services;

import com.ironhack.FinalProject.controllers.interfaces.ThirdPartyControllerInt;
import com.ironhack.FinalProject.models.DTO.ThirdPartyTransferenceDto;
import com.ironhack.FinalProject.models.Movements.ThirdPartyTransference;
import com.ironhack.FinalProject.models.Users.ThirdParty;
import com.ironhack.FinalProject.repositories.UserRepositories.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService implements ThirdPartyControllerInt {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public ThirdParty addAThirdParty(ThirdParty thirdParty) {
        return thirdPartyRepository.save(thirdParty);
    }

    //Falta logica:
    public ThirdParty addTransference(String thirdPartyKey, ThirdPartyTransferenceDto transferenceDTO) {
        return null;
    }


    @Override
    public ThirdParty makeThirdPartyTransference(String thirdPartyKey, ThirdPartyTransferenceDto transferenceDTO) {
        return null;
    }
}
