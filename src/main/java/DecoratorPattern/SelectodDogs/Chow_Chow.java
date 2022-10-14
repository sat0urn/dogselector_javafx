package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Chow_Chow extends SelectedDog {
    public Chow_Chow() {
        description = "Chow Chow";
    }

    @Override
    public double cost() {
        return 1.29;
    }
}
