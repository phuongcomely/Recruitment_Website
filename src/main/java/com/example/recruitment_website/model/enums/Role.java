package com.example.recruitment_website.model.enums;

import lombok.Getter;

@Getter
public enum Role {
    CANDIDATE("CANDIDATE"),
    EMPLOYER("EMPLOYER"),
    ADMIN("ADMIN");

    private final String value;

    Role(String value) {
        this.value = value;
    }
}
