package StatePattern;

import models.Client;

public class AcquisitionSettingTime {

    State settedState;
    State unsettedState;

    State state;
    Client client;

    public AcquisitionSettingTime(Client client) {
        settedState = new SettedState(this);
        unsettedState = new UnsettedState(this);

        state = unsettedState;
        this.client = client;
    }

    public void setDateToClient() {
        state.setDateToClient(client);
    }

    public void setState(State state) {
        this.state = state;
    }
}
