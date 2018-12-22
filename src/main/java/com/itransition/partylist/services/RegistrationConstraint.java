package com.itransition.partylist.services;

import com.itransition.partylist.models.JoinPartyRequest;

public interface RegistrationConstraint {

    boolean registrationAllowed(JoinPartyRequest request);
}
