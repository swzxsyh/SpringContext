package com.test.application.designPatten.structuralPattern.adapterPattern.adapters;

import com.test.application.designPatten.structuralPattern.adapterPattern.round.RoundPeg;
import com.test.application.designPatten.structuralPattern.adapterPattern.square.SquarePeg;

public class SquarePegAdapter extends RoundPeg {

    private final SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        return Math.sqrt(Math.pow(peg.getWidth() / 2, 2) * 2);
    }
}
