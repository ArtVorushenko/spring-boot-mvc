package com.itransition.partylist.services;

import com.itransition.partylist.models.Gender;
import com.itransition.partylist.models.JoinPartyRequest;
import com.itransition.partylist.repositories.PartyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class AlwaysAllowRegistrationConstraint implements RegistrationConstraint {

    @Autowired
    private PartyMemberRepository repository;

    @Override
    public boolean registrationAllowed(JoinPartyRequest request) {
        return true;
    }
}
