package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class NameApplication implements ValueObject<String> {
    private final String nameApplication;

    public NameApplication(String nameApplication) {
        this.nameApplication = nameApplication;
    }

    @Override
    public String value() {
        return nameApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameApplication nameApplication = (NameApplication) o;
        return Objects.equals(nameApplication, nameApplication.nameApplication);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nameApplication);
    }
}
