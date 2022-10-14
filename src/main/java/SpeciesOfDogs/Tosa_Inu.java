package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Big;

public class Tosa_Inu extends Dog{
    private final String dogSpeecy = "Tosa Inu";

    @Override
    public String displayMessage() {
        return "You should peek " + dogSpeecy + "\n" +
                dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Aggressive().mood() + "\n" +
                "4. " + new Domestic().lifestyle();
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
