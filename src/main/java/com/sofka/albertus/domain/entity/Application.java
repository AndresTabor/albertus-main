package com.sofka.albertus.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertus.domain.values.ApplicationId;
import com.sofka.albertus.domain.values.Description;
import com.sofka.albertus.domain.values.IsActive;
import com.sofka.albertus.domain.values.NameApplication;

public class Application extends Entity<ApplicationId> {

    private NameApplication nameApplication;
    private Description description;
    private IsActive isActive;


    public Application(ApplicationId entityId,
                       NameApplication nameApplication,
                       Description description,
                       IsActive isActive) {

        super(entityId);
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
    }

    public NameApplication getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(NameApplication nameApplication) {
        this.nameApplication = nameApplication;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public IsActive getIsActive() {
        return isActive;
    }

    public void setIsActive(IsActive isActive) {
        this.isActive = isActive;
    }
}
