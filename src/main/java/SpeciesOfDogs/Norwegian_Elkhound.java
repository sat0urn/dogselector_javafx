package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Medium;

public class Norwegian_Elkhound extends Dog {
    private final String dogSpeecy = "Norwegian Elkhound";

    @Override
    public String displayMessage() {
        return "You should peek " + dogSpeecy + "\n" +
                dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Medium().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Street().lifestyle();
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
