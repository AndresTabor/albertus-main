package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.domain.values.IsActive;

public class ApplicationDeleted extends DomainEvent {

    private String applicationID;
    private IsActive isActive;

    public ApplicationDeleted(String applicationID, IsActive isActive) {
        super("sofka.albertus.domain.ApplicationDeleted");
        this.applicationID = applicationID;
        this.isActive = isActive;
    }



    public String getApplicationID() {
        return applicationID;
    }

    public IsActive getIsActive() {
        return isActive;
    }
}
