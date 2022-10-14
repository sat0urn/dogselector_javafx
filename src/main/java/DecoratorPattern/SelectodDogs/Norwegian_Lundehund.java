package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Small;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Norwegian_Lundehund extends SelectedDog {
    public Norwegian_Lundehund() {
        description = "Norwegian Lundehund";
    }

    @Override
    public double cost() {
        return 1.45;
    }
}
