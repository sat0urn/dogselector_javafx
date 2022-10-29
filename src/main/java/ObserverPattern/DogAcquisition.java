package ObserverPattern;

import StatePattern.AcquisitionSettingTime;
import StatePattern.SettedState;
import StatePattern.UnsettedState;
import com.example.ClientDBUtils;
import javafx.scene.control.Alert;
import models.Client;

import java.util.List;

public class DogAcquisition implements Observable {

    List<Observer> observers;

    public DogAcquisition() {
        observers = ClientDBUtils.getAllClients();
    }

    @Override
    public void registerObserver(Observer o) {
        AcquisitionSettingTime acquisitionSettingTime = new AcquisitionSettingTime((Client) o);
        acquisitionSettingTime.setState(new SettedState(acquisitionSettingTime));
        for (Observer observer : observers) {
            if (observer.getName().equals(o.getName()) &&
                    observer.getDogBreed().equals(o.getDogBreed()) &&
                    observer.getLogin().equals(o.getLogin())) {
                acquisitionSettingTime.setDateToClient();
                System.out.println("State was changed!");
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
        String[] allNotifies;
        int length = 0, i = 0;
        for (Observer observer : observers)
            if (observer.getName().equals(observerName))
                length++;


        allNotifies = new String[length];
        for (Observer observer : observers) {
            if (observer.getName().equals(observerName)) {
                allNotifies[i] = observer.update();
                i++;
            }
        }
        return allNotifies;
    }
}
