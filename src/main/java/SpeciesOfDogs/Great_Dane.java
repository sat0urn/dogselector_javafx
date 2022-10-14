package SpeciesOfDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;

public class Great_Dane extends Dog {
    private final String dogSpeecy = "Great Dane";

    @Override
    public String displayMessage() {
        return "You should peek " + dogSpeecy + "\n" +
                dogSpeecy + " features are \n" +
                "1. " + new NoTrained().intellect() + "\n" +
                "2. " + new Big().size() + "\n" +
                "3. " + new Calm().mood() + "\n" +
                "4. " + new Domestic().lifestyle();
    }

    @Override
    public String getDogSpeecy() {
        return this.dogSpeecy;
    }
}
