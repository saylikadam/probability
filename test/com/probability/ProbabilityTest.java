package com.probability;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saylik on 3/11/2015.
 */
public class ProbabilityTest {
    @Test
    public void isProbability_should_return_true_for_probability_between_0_to_1() {
        Probability probability = Probability.calculateProbability(5,3);
        assertNotNull(probability);

    }

    @Test
    public void isProbability_should_return_false_for_probability_not_between_0_to_1() {
        Probability p = Probability.calculateProbability(3, 5);
        assertNull(p);
    }

    @Test
    public void notTails_should_return_the_probability_of_not_getting_tails() {
        Probability probability = Probability.calculateProbability(5, 3);
        Probability expected = Probability.calculateProbability(5, 2);
        Probability nt = probability.nagate();
        assertTrue(nt.equals(expected));
    }

    @Test
    public void probabilityOfTwoCoinsGettingTails() {
        Probability probability = Probability.calculateProbability(5, 3);
        Probability probability2 = Probability.calculateProbability(5, 3);
        Probability expected = Probability.calculateProbability(25, 9);
        Probability andProbability = probability.and(probability2);

        assertTrue(andProbability.equals(expected));
    }

    @Test
    public void probabilityAtleastOneOfTwoCoinsGettingTail() {
        Probability probability = Probability.calculateProbability(5, 3);
        Probability probability2 = Probability.calculateProbability(6, 3);
        Probability expected = Probability.calculateProbability(5, 4);
        Probability orProbability = probability.or(probability2);

        assertTrue(orProbability.equals(expected));
    }
}
