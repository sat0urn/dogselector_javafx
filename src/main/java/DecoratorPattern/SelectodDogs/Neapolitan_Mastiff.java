package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Neapolitan_Mastiff extends SelectedDog {
    public Neapolitan_Mastiff() {
        description = "Neapolitan Mastiff";
    }

    @Override
    public double cost() {
        return 1.43;
    }
}
