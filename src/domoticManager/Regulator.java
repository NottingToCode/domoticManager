package domoticManager;

public interface Regulator extends DomoticDevice {
	void setValue(int value);

	int getValue();

	int getMaxValue();
}