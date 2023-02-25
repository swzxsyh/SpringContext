package com.test.application.designPatten.structuralPattern.adapterPattern;

import com.test.application.designPatten.structuralPattern.adapterPattern.adapters.SquarePegAdapter;
import com.test.application.designPatten.structuralPattern.adapterPattern.round.RoundHole;
import com.test.application.designPatten.structuralPattern.adapterPattern.round.RoundPeg;
import com.test.application.designPatten.structuralPattern.adapterPattern.square.SquarePeg;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);

        if(hole.fits(rpeg)){
            log.info("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);

        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);

        if (hole.fits(smallSqPegAdapter)){
            log.info("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(largeSqPegAdapter)){
            log.info("Square peg w20 does not fit into round hole r5.");
        }


    }
}
