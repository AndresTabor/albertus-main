package com.sofka.albertus.domain.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Type implements ValueObject<String> {
    private final String type;

    public Type(String type) {
        this.type = type;
    }

    @Override
    public String value() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(type, type.type);
    }
    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
