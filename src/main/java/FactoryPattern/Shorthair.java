package FactoryPattern;

public class Shorthair extends Hairtype {
    private String shortHair = "shorthaired";
    private String dogBreed;

    public Shorthair() {}

    Shorthair(String dogBreed) {
        this.dogBreed = dogBreed;
        hairType = shortHair;
    }

    @Override
    public String getDogAndHairType() {
        return dogBreed + " is " + this.shortHair + " dog!";
    }

    @Override
    public String getHairType() {
        return this.shortHair;
    }
}
