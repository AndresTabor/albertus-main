package com.sofka.albertus.domain.usecase;


import com.sofka.albertus.domain.commands.AddApplicationID;

public class AddApplicationIDUseCase extends UseCaseForCommand<AddApplicationID> {

    private String applicationID;
    private String userID;

    public AddApplicationIDUseCase(String applicationID, String userID) {
        this.applicationID = applicationID;
        this.userID = userID;
    }

    public AddApplicationIDUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getUserID() {
        return userID;
    }
}
