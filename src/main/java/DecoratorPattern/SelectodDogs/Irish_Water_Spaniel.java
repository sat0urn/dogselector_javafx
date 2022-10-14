package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Aggressive;
import Behaviors_and_Realizations.size_realizations.Medium;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Irish_Water_Spaniel extends SelectedDog {
    public Irish_Water_Spaniel() {
        description = "Irish Water Spaniel";
    }

    @Override
    public double cost() {
        return 1.39;
    }
}
