package models;

import ObserverPattern.*;

public class Client implements Observer {
    private String dogBuyer;
    private String login;
    private String dogSpeecy;
    private String date;
    private String description;
    private double cost;

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

    public Client(String dogBuyer, String login, String dogSpeecy, String description, double cost) {
        this.dogBuyer = dogBuyer;
        this.login = login;
        this.dogSpeecy = dogSpeecy;
        this.description = description;
        this.cost = cost;
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
    @Override
    public String getLogin() { return this.login; }

    public String getDate() {
        return this.date;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
}
