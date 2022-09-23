package com.sofka.albertus.domain.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ApplicationRegistered extends DomainEvent {

    private String nameApplication;

    private String description;

    private Boolean isActive;

    public ApplicationRegistered(String nameApplication, String description, Boolean isActive) {
        super("sofka.albertus.domain.ApplicationRegistered");
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}
