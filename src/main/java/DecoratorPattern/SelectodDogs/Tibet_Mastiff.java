package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.Trained;
import Behaviors_and_Realizations.lifestyle_realizations.Street;
import Behaviors_and_Realizations.mood_realizations.Active;
import Behaviors_and_Realizations.size_realizations.Big;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Tibet_Mastiff extends SelectedDog {
    public Tibet_Mastiff() {
        description = "Tibet Mastiff";
    }

    @Override
    public double cost() {
        return 1.53;
    }
}
