package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class CreateBlockUseCase extends Command {

    private String applicationID;
    private String data;

    public CreateBlockUseCase(String applicationID, String data) {
        this.applicationID = applicationID;
        this.data = data;
    }

    public CreateBlockUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getData() {
        return data;
    }
}
