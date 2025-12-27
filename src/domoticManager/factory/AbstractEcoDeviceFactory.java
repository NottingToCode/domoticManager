package domoticManager.factory;

import domoticManager.Regulator;

public interface AbstractEcoDeviceFactory {
	
    Regulator createEcoLight(String name);
    Regulator createEcoRadiator(String name);
    Regulator createEcoFan(String name);

}
