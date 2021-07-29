package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestAccessibilityFeatures extends EnterpriseLangTest {

    private static class accessibilityFeatures {
        public final Windows windows = new Windows("windows");
        public final Computer computer = new Computer("computer");
        public final OS os = new OS("os");
        
        public accessibilityFeatures() {
            computer.addOs(os); 

        }
    }
/*
    @Test
    public void infectedHardware(){
        var model = new accessibilityFeatures();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.accessibilityFeatures);
        attacker.attack();

        model.computer.infectedWindowsComputer.assertCompromisedInstantaneously();
    }
*/
    @Test
    public void infectedOS(){
        var model = new accessibilityFeatures();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.accessibilityFeatures);
        attacker.attack();

        model.os.accessibilityFeatures.assertCompromisedInstantaneously();
        model.os.executeCode.assertCompromisedInstantaneously();
        //model.os.remoteDesktopProtocol.assertCompromisedInstantaneously();
        //model.os.commandExecution.assertCompromisedInstantaneously();
    }
}