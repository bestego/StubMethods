package nl.bestego.mocking;

public class StaticRandom {

    static boolean  random() throws RandomException {
        if (Math.random() < (double) 1 / 3) return false;
        if (Math.random() > (double) 2 / 3) return true;
        throw new RandomException("in the middle");
    }
}

