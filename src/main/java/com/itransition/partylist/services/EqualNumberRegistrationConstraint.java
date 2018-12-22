package com.itransition.partylist.services;

import com.itransition.partylist.models.Gender;
import com.itransition.partylist.models.JoinPartyRequest;
import com.itransition.partylist.repositories.PartyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class EqualNumberRegistrationConstraint implements RegistrationConstraint {

    @Autowired
    private PartyMemberRepository repository;

    @Override
    public boolean registrationAllowed(JoinPartyRequest request) {
        return Gender.FEMALE.equals(request.getGender())
                || repository.countByGender(Gender.FEMALE) >= repository.countByGender(Gender.MALE);
    }
}
