package com.sofka.albertus.business.usecases.gateways.commands;

import co.com.sofka.domain.generic.Command;
import com.sofka.albertus.domain.values.IsActive;

public class DeleteApplication extends Command {


    private String applicationID;
    private IsActive isActive;

    public DeleteApplication(String applicationID, IsActive isActive) {
        this.applicationID = applicationID;
        this.isActive = isActive;
    }

    public DeleteApplication() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public IsActive getIsActive() {
        return isActive;
    }
}
