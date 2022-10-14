package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Caucasion_Shephard extends SelectedDog {
    public Caucasion_Shephard() {
        description = "Caucasion Shephard";
    }

    @Override
    public double cost() {
        return 1.27;
    }
}
