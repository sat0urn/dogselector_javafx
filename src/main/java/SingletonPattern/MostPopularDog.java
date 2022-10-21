package SingletonPattern;

public class MostPopularDog {
    private String popularDog;
    private static MostPopularDog instance;

    private MostPopularDog(String popularDog) {
        this.popularDog = popularDog;
    }

    public static synchronized MostPopularDog getInstance(String popularDog) {
        if (instance == null) {
            instance = new MostPopularDog(popularDog);
        }
        return instance;
    }

    public String getPopularDog() {
        return popularDog;
    }
}
