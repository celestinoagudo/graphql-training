package com.graphql.training.application.constant;

public enum SubjectName {

    COM_INT("Computational Intelligence"),
    COM_DES("Compiler Design"),
    MOD_SIM("Modelling & Simulation");
    private final String name;

    private SubjectName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
