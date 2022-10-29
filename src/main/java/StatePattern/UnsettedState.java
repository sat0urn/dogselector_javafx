package StatePattern;

import com.example.DBUtils;
import models.Client;

public class UnsettedState implements State {
    AcquisitionSettingTime acquisitionSettingTime;

    public UnsettedState(AcquisitionSettingTime acquisitionSettingTime) {
        this.acquisitionSettingTime = acquisitionSettingTime;
    }

    @Override
    public void setDateToClient(Client client) {
        DBUtils.sendMessageToAdmin(client, client.getDogBreed(), client.getDescription(), client.getCost());
    }
}
