package domoticManager.sensors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import domoticManager.devices.AbstractDomoticDevice;
import domoticManager.observer.IObserver;

public abstract class AbstractSensor<T> extends AbstractDomoticDevice {

    private T value;
    
    private final Collection<IObserver> observers = new ArrayList<>();

    public AbstractSensor(String name) {
        super(name);
    }

    public T getValue() {
        return value;
    }

    protected void setValue(T value) {
        this.value = value;
    }

    public void attach(IObserver observer) {
        observers.add(observer);
    }

    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        List<IObserver> safeCopy = new ArrayList<>(this.observers);
        safeCopy.forEach(IObserver::update);
    }

    public abstract void updateValue(T newValue);
}