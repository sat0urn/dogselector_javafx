package Behaviors_and_Realizations.lifestyle_realizations;

import Behaviors_and_Realizations.LifestyleBehavior;

public class Street implements LifestyleBehavior {
    @Override
    public String lifestyle() {
        return "Street";
    }

    @Override
    public boolean lifestyle(String lifestyle) {
        return lifestyle().equals(lifestyle);
    }
}
