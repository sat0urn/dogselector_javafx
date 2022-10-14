package Behaviors_and_Realizations.size_realizations;

import Behaviors_and_Realizations.SizeBehavior;

public class Small implements SizeBehavior {
    @Override
    public String size() {
        return "Small";
    }

    @Override
    public boolean size(String size) {
        return size().equals(size);
    }
}
