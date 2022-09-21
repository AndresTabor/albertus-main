package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class UpdateApplicationUseCase extends Command {

    private String applicationID;
    private String nameApplication;
    private String description;

    public UpdateApplicationUseCase(String applicationID, String nameApplication, String description) {
        this.applicationID = applicationID;
        this.nameApplication = nameApplication;
        this.description = description;
    }

    public UpdateApplicationUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getNameApplication() {
        return nameApplication;
    }

    public String getDescription() {
        return description;
    }
}
