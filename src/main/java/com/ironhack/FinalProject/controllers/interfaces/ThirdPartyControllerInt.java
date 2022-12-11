package com.ironhack.FinalProject.controllers.interfaces;

import com.ironhack.FinalProject.models.DTO.ThirdPartyTransferenceDto;
import com.ironhack.FinalProject.models.Users.ThirdParty;

public interface ThirdPartyControllerInt {
    ThirdParty makeThirdPartyTransference(String thirdPartyKey, ThirdPartyTransferenceDto transferenceDTO);
}
