package FactoryPattern;

public class Longhair extends Hairtype {

    private String longHair = "longhaired";
    private String dogBreed;

    public Longhair() {}

    Longhair(String dogBreed) {
        hairType = longHair;
        this.dogBreed = dogBreed;
    }

    @Override
    public String getDogAndHairType() {
        return dogBreed + " is " + this.longHair + " dog!";
    }

    @Override
    public String getHairType() {
        return this.longHair;
    }
}
