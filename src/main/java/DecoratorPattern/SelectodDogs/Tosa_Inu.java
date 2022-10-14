package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Tosa_Inu extends SelectedDog {
    public Tosa_Inu() {
        description = "Tosa Inu";
    }

    @Override
    public double cost() {
        return 1.54;
    }
}
