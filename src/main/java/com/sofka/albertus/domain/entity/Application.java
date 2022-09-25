package com.sofka.albertus.domain.entity;

import co.com.sofka.domain.generic.Entity;
import com.sofka.albertus.domain.values.*;

public class Application extends Entity<ApplicationId> {

    private Name nameApplication;
    private Description description;
    private Boolean isActive;

    private UserId userId;
    public Application(ApplicationId entityId,
                       Name nameApplication,
                       Description description,
                       Boolean isActive, UserId userId) {

        super(entityId);
        this.nameApplication = nameApplication;
        this.description = description;
        this.isActive = isActive;
        this.userId = userId;
    }

    public Name getNameApplication() {
        return nameApplication;
    }

    public void setNameApplication(Name nameApplication) {
        this.nameApplication = nameApplication;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public void updateApplication(String nameApplication, String descriptionApplication){
        this.nameApplication = new Name(nameApplication);
        this.description = new Description(descriptionApplication);
    }

    public  void deleteApplication(){
        this.isActive = false;
    }

}
