package com.ironhack.FinalProject.controllers;
import com.ironhack.FinalProject.controllers.interfaces.ThirdPartyControllerInt;
import com.ironhack.FinalProject.models.DTO.ThirdPartyTransferenceDto;
import com.ironhack.FinalProject.models.Users.ThirdParty;
import com.ironhack.FinalProject.services.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ThirdPartyController implements ThirdPartyControllerInt {

    @Autowired
    ThirdPartyService thirdPartyService;

    @PostMapping("/transfer-money")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty makeThirdPartyTransference(@RequestHeader String thirdPartyKey, @RequestBody ThirdPartyTransferenceDto transferenceDTO) {

        return thirdPartyService.addTransference(thirdPartyKey, transferenceDTO);

    }


}
