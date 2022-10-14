package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class German_Shorthaired_Pointer extends SelectedDog {
    public German_Shorthaired_Pointer() {
        description = "German Shorthaired Pointer";
    }

    @Override
    public double cost() {
        return 1.34;
    }
}
