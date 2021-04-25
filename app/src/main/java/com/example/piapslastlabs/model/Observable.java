package com.example.piapslastlabs.model;

public interface Observable {

    void RegisterObserver(Observer o);
    void RemoveObserver(Observer o);
    void NotifyObservers(int id);

}
