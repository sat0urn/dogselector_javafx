package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Norwegian_Elkhound extends SelectedDog {
    public Norwegian_Elkhound() {
        description = "Norwegian Elkhound";
    }

    @Override
    public double cost() {
        return 1.44;
    }
}
