package com.itransition.partylist.controllers;

import com.itransition.partylist.exceptions.RegistrationFailedException;
import com.itransition.partylist.models.JoinPartyRequest;
import com.itransition.partylist.services.PartyListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestAPIController {

    @Autowired
    private PartyListService partyListService;

    @PostMapping("/member")
    public void addNewMember(@RequestBody @Valid JoinPartyRequest request, BindingResult result) throws RegistrationFailedException {
        if (result.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            partyListService.registerNewMember(request);
        }
    }

    @ExceptionHandler({RegistrationFailedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleException(){

    }
}
