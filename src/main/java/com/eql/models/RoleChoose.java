package com.eql.models;


public class RoleChoose {
    private String label;

    public RoleChoose() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RoleChoose(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Role{"+
                ", label='" + label + '\'' +
                '}';
    }
}
