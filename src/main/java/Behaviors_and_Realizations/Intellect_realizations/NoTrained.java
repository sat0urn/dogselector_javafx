package Behaviors_and_Realizations.Intellect_realizations;

import Behaviors_and_Realizations.IntellectBehavior;

public class NoTrained implements IntellectBehavior {
    @Override
    public String intellect() {
        return "NoTrained";
    }

    @Override
    public boolean intellect(String intellect) {
        return intellect().equals(intellect);
    }
}
