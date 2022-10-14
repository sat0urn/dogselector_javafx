package DecoratorPattern;

public abstract class SelectedDog {
    public String description = "Unknown Dog";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
