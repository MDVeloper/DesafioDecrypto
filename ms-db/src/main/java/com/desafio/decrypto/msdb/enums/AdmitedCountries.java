package com.desafio.decrypto.msdb.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum AdmitedCountries {
    ARGENTINA("Argentina"),
    URUGUAY("Uruguay");

    private static final Map<String, AdmitedCountries> mapper = newMapper();
    private final String description;

    AdmitedCountries(final String description) {
        this.description = description;
    }

    private static Map<String, AdmitedCountries> newMapper() {
        return Arrays.stream(values()).collect(Collectors.toMap(AdmitedCountries::getDescription, e -> e));
    }

    /**
     * @param description description
     * @return
     */
    public static AdmitedCountries getByDescription(final String description) {
        return mapper.get(description);
    }

    /**
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    public static AdmitedCountries resolveByName(final String name) {
        return Arrays.stream(values()).filter(e -> e.name().equals(name)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Countrys{")
                .append("description='").append(this.description).append('\'')
                .append('}').toString();
    }
}
