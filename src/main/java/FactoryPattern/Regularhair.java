package FactoryPattern;

public class Regularhair extends Hairtype {
    private String regularHair = "regularhaired";
    private String dogBreed;

    public Regularhair() {}

    Regularhair(String dogBreed) {
        hairType = regularHair;
        this.dogBreed = dogBreed;
    }

    @Override
    public String getDogAndHairType() {
        return dogBreed + " is " + this.regularHair + " dog!";
    }

    @Override
    public String getHairType() {
        return this.regularHair;
    }
}
