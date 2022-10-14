package DecoratorPattern.SelectodDogs;

import DecoratorPattern.SelectedDog;

public class Basset_Hound extends SelectedDog {
    public Basset_Hound() {
        description = "Basset Hound";
    }

    @Override
    public double cost() {
        return 1.21;
    }
}
