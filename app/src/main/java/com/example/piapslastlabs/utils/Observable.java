package com.example.piapslastlabs.utils;

import com.example.piapslastlabs.model.QuestionInterface;
import com.example.piapslastlabs.utils.Observer;

public interface Observable {

    void RegisterObserver(Observer o);
    void RemoveObserver(Observer o);
    void NotifyObservers(QuestionInterface questionInterface);

}
