package DecoratorPattern;

public class DepRecFunc extends DogServices {

    public DepRecFunc(SelectedDog selectedDog) {
        this.selectedDog = selectedDog;
    }

    @Override
    public String getDescription() {
        return selectedDog.getDescription() + ", Deprivation of Reproductive Function";
    }

    @Override
    public double cost() {
        return selectedDog.cost() + 5.0;
    }
}
