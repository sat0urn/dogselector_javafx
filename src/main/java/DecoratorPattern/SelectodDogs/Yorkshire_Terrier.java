package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Small;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Yorkshire_Terrier extends SelectedDog {
    public Yorkshire_Terrier() {
        description = "Yorkshire Terrier";
    }

    @Override
    public double cost() {
        return 1.55;
    }
}
