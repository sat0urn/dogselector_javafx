package DecoratorPattern.SelectodDogs;

import Behaviors_and_Realizations.Intellect_realizations.NoTrained;
import Behaviors_and_Realizations.lifestyle_realizations.Domestic;
import Behaviors_and_Realizations.mood_realizations.Calm;
import Behaviors_and_Realizations.size_realizations.Small;
import DecoratorPattern.SelectedDog;
import SpeciesOfDogs.Dog;

public class Pug extends SelectedDog {
    public Pug() {
        description = "Pug";
    }

    @Override
    public double cost() {
        return 1.49;
    }
}
