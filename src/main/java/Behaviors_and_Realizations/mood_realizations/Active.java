package Behaviors_and_Realizations.mood_realizations;

import Behaviors_and_Realizations.MoodBehavior;

public class Active implements MoodBehavior {
    @Override
    public String mood() { return "Active"; }

    @Override
    public boolean mood(String mood) {
        return mood().equals(mood);
    }
}
