package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Ghanaian extends SelectedDog {
    public Ghanaian() {
        description = "Ghanaian";
    }

    @Override
    public double cost() {
        return 1.35;
    }
}
