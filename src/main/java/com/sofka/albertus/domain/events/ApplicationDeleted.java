package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofka.albertus.domain.values.IsActive;

public class ApplicationDeleted extends DomainEvent {

    private String applicationID;
    private Boolean isActive;

    public ApplicationDeleted(String applicationID, Boolean isActive) {
        super("sofka.albertus.domain.ApplicationDeleted");
        this.applicationID = applicationID;
        this.isActive = isActive;
    }



    public String getApplicationID() {
        return applicationID;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
