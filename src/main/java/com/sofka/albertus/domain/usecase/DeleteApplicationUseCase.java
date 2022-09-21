package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class DeleteApplicationUseCase extends Command {


    private String applicationID;

    public DeleteApplicationUseCase(String applicationID) {
        this.applicationID = applicationID;
    }

    public DeleteApplicationUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }
}
