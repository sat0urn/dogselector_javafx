package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Bullmastiff extends SelectedDog {
    public Bullmastiff() {
        description = "Bullmastiff";
    }

    @Override
    public double cost() {
        return 1.26;
    }
}
