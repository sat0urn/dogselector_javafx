package FactoryPattern;

public class HairTypeFactory {
    public static Hairtype getHairType(String dogBreed, String hairType) {
        if (hairType.equalsIgnoreCase("longhaired"))
            return new Longhair(dogBreed);
        else if (hairType.equalsIgnoreCase("shorthaired"))
            return new Shorthair(dogBreed);
        else
            return new Regularhair(dogBreed);
    }
}
