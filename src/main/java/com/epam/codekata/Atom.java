package com.epam.codekata;

public class Atom {
    private String name;
    private double atomic_mass;

    private byte number;

    public Atom(String name, double atomic_mass, byte number) {
        this.name = name;
        this.atomic_mass = atomic_mass;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAtomic_mass() {
        return atomic_mass;
    }

    public void setAtomic_mass(double atomic_mass) {
        this.atomic_mass = atomic_mass;
    }

    public byte getNumber() {
        return number;
    }

    public void setNumber(byte number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Atom{" +
                "name='" + name + '\'' +
                ", atomic_mass=" + atomic_mass +
                ", number=" + number +
                '}';
    }
}
