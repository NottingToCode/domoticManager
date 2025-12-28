package domoticManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractSensor<T> extends AbstractDomoticDevice {

	protected T value;
	// Uso List per chiarezza, inizializzata come ArrayList
	private final Collection<IObserver> observers = new ArrayList<>();

	public AbstractSensor(String name) {
		super(name);
	}

	// Metodo reintrodotto (era mancante)
	public T getValue() {
		return value;
	}

	// Metodo reintrodotto (era mancante)
	public void attach(IObserver observer) {
		observers.add(observer);
	}

	// Metodo reintrodotto (era mancante)
	public void detach(IObserver observer) {
		observers.remove(observer);
	}

	// La versione robusta (corretta)
	protected void notifyObservers() {
		// Creiamo una COPIA della lista prima di iterare per sicurezza
		List<IObserver> safeCopy = new ArrayList<>(this.observers);
		safeCopy.forEach(IObserver::update);
	}

	public abstract void updateValue(T newValue);
}