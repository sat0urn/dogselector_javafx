package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Golden_Retriever extends SelectedDog {
    public Golden_Retriever() {
        description = "Golden Retriever";
    }

    @Override
    public double cost() {
        return 1.36;
    }
}
