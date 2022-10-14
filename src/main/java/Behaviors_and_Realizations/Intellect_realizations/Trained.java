package Behaviors_and_Realizations.Intellect_realizations;

import Behaviors_and_Realizations.IntellectBehavior;

public class Trained implements IntellectBehavior {
    @Override
    public String intellect() { return "Trained"; }

    @Override
    public boolean intellect(String intellect) {
        return intellect().equals(intellect);
    }
}
