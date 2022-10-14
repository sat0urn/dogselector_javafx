package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Bulldog extends SelectedDog {
    public Bulldog() {
        description = "Bulldog";
    }

    @Override
    public double cost() {
        return 1.25;
    }
}
