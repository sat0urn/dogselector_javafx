package DecoratorPattern;

public abstract class DogServices extends SelectedDog {
    SelectedDog selectedDog;
    public abstract String getDescription();
}
