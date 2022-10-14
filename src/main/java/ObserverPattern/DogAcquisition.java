package ObserverPattern;

import com.example.ClientDBUtils;
import javafx.scene.control.Alert;

import java.util.List;

public class DogAcquisition implements Observable {

    List<Observer> observers;

    public DogAcquisition() {
        observers = ClientDBUtils.getAllClients();
    }

    @Override
    public void registerObserver(Observer o) {
        for (Observer observer : observers) {
            if (observer.getName().equals(o.getName()) &&
                    observer.getDogBreed().equals(o.getDogBreed()) &&
                    observer.getLogin().equals(o.getLogin())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("This client is already has that dog!");
                alert.show();
                return;
            }
        }
        observers.add(o);
        ClientDBUtils.addNewClient(o);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Client is added successfully!");
        alert.show();
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        ClientDBUtils.removeClient(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String[] notifyObserver(String observerName) {
        String[] allNotifies = new String[observers.toArray().length];
        int c = 0;
        for (Observer observer : observers) {
            if (observer.getName().equals(observerName)) {
                allNotifies[c] = observer.update();
                c++;
            }
        }
        return allNotifies;
    }
}
