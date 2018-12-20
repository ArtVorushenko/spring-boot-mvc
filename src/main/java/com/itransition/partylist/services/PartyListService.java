package com.itransition.partylist.services;

import com.itransition.partylist.entities.PartyMemberEntity;
import com.itransition.partylist.models.JoinPartyRequest;
import com.itransition.partylist.repositories.PartyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyListService {

    @Autowired
    private PartyMemberRepository repository;

    public void registerNewMember(JoinPartyRequest request) {
        PartyMemberEntity entity = new PartyMemberEntity(request.getName(), request.getAge(), request.getGender());
        repository.save(entity);
    }

}
