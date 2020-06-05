package nl.bestego.mocking;

public class Logic {

    Random rnd = new Random();

    String message;

    public String run() {
        try {
            if (rnd.random()) {
                message = "Random greater than 2/3";
            } else {
                message = "Random less than 1/3";
            }
        } catch (RandomException e) {
            message = "Random between 1/3 .. 2/3";
        }
        System.out.println(message);
        return message;
    }
}
