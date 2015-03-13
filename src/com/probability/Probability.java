package com.probability;

/**
 * Created by saylik on 3/11/2015.
 */
public class Probability {
//    private static final double PRECESSION = 0.001;
    private static final int CERTAINTY = 1;
    private double probability;
    private static final int LOWEST_POSSIBLE_CHANCE = 0;

    private Probability(double value) {
        probability = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Probability that = (Probability) o;

        if (Double.compare(that.probability, probability) != 0) return false;

        return true;
    }

    public static Probability calculateProbability(int chances, int favourable) {
        if(favourable > chances || favourable < LOWEST_POSSIBLE_CHANCE || chances < LOWEST_POSSIBLE_CHANCE)
            return null;
        return new Probability((double)favourable/chances);
    }

    public Probability nagate() {
        return new Probability(CERTAINTY - probability);
    }

    public Probability and(Probability probability2) {
        return new Probability(this.probability * probability2.probability);
    }

    public Probability or(Probability probability2) {
        return this.nagate().and(probability2.nagate()).nagate();
    }
}
