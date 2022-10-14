package models;

import ObserverPattern.*;

public class Client implements Observer {
    private String dogBuyer;
    private String login;
    private String dogSpeecy;
    private String date;

    public Client() {}

    public Client(String dogBuyer, String login, String dogSpeecy) {
        this.dogBuyer = dogBuyer;
        this.login = login;
        this.dogSpeecy = dogSpeecy;
    }

    public Client(String dogBuyer, String login, String dogSpeecy, String date) {
        this.dogBuyer = dogBuyer;
        this.login = login;
        this.dogSpeecy = dogSpeecy;
        this.date = date;
    }


    @Override
    public String update() {
        return this.dogBuyer + " is waiting for " + this.dogSpeecy + ", date to pickup is: " + this.date;
    }

    @Override
    public String getName() {
        return this.dogBuyer;
    }

    @Override
    public String getDogBreed() {
        return this.dogSpeecy;
    }

    public String getDate() {
        return this.date;
    }
    @Override
    public String getLogin() { return this.login; }
}
