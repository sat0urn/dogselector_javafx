package ObserverPattern;

public interface Observable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    String[] notifyObserver(String observerName);
}
