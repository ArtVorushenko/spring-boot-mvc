package com.itransition.partylist.repositories;

import com.itransition.partylist.entities.PartyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyMemberRepository extends JpaRepository<PartyMemberEntity, Long> {

}
