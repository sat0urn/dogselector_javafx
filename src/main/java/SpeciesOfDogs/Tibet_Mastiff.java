package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Big;

public class Tibet_Mastiff extends Dog {
    private final String dogSpeecy = "Tibet Mastiff";

    @Override
    public String displayMessage() {
        return "You should peek " + dogSpeecy + "\n" +
                dogSpeecy + " features are \n" +
                "1. " + new Trained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Active().mood() + "\n" +
                "4. " + new Street().lifestyle();
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
