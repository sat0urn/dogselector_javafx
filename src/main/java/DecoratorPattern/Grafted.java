package DecoratorPattern;

public class Grafted extends DogServices {

    public Grafted(SelectedDog selectedDog) {
        this.selectedDog = selectedDog;
    }

    @Override
    public String getDescription() {
        return selectedDog.getDescription() + ", vaccination";
    }

    @Override
    public double cost() {
        return selectedDog.cost() + 4.6;
    }
}
