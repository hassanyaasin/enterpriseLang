package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDataFromRemovableMedia extends EnterpriseLangTest {

    private static class dataFromRemovableMedia {
        public final Computer computer = new Computer("computer");
        public final PeripheralDevice peripheralDevice = new PeripheralDevice("peripheralDevice");
    }

    @Test
    public void infectedComputer(){
        var model = new dataFromRemovableMedia();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.computer.infectedComputer);
        attacker.attack();

        model.computer.infectedComputer.assertCompromisedInstantaneously();
        //model.computer.peripheralDeviceDiscovery.assertCompromisedInstantaneously();
    }

    @Test
    public void removableMedia(){
        var model = new dataFromRemovableMedia();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.peripheralDevice.dataExfiltration);
        attacker.attack();

        model.peripheralDevice.dataExfiltration.assertCompromisedInstantaneously();
    }
}