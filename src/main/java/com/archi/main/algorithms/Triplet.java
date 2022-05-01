package com.archi.main.algorithms;

public class Triplet {

    private final Double lower;
    private final Double middle;
    private final Double upper;

    public Triplet(Double lower, Double middle, Double upper) {
        this.lower = (double) Math.round(lower * 1000) / 1000;
        this.middle = (double) Math.round(middle * 1000) / 1000;
        this.upper = (double) Math.round(upper * 1000) / 1000;
    }

    public Double getLower() {
        return (double) Math.round(lower * 1000) / 1000;
    }

    public Double getMiddle() {
        return (double) Math.round(middle * 1000) / 1000;
    }

    public Double getUpper() {
        return (double) Math.round(upper * 1000) / 1000;
    }

    public Double getSum() {
        return lower + middle + upper;
    }

    public Double getLowerDiff() {
        return (double) Math.round((middle - lower) * 1000) / 1000;
    }

    public Double getUpperDiff() {
        return (double) Math.round((upper - middle) * 1000) / 1000;
    }

}