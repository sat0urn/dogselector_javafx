package StatePattern;

import com.example.DBConfig;
import javafx.scene.control.Alert;
import models.Client;

import java.sql.*;

public class SettedState implements State {
    AcquisitionSettingTime acquisitionSettingTime;

    public SettedState(AcquisitionSettingTime acquisitionSettingTime) {
        this.acquisitionSettingTime = acquisitionSettingTime;
    }

    @Override
    public void setDateToClient(Client client) {
        try (Connection con = DriverManager.getConnection(DBConfig.URL, DBConfig.NAME, DBConfig.PASSWORD);
             PreparedStatement st = con.prepareStatement(
                     "SELECT * FROM clients WHERE login = \'" + client.getLogin()
                             + "\' AND date IS NULL"
             )) {

            ResultSet rs = st.executeQuery();

            if (!rs.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("This client is already have an acquisition date time for that dog!");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
