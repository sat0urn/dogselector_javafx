package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Small;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Mixed_Breed_2 extends SelectedDog {
    public Mixed_Breed_2() {
        description = "Mixed Breed #2";
    }

    @Override
    public double cost() {
        return 1.42;
    }
}
