package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDataFromLocalSystem extends EnterpriseLangTest {

    private static class dataFromLocalSystem {
        public final Computer computer = new Computer("computer");
        public final OS os = new OS("os");
    }

    @Test
    public void infectedComputer(){
        var model = new dataFromLocalSystem();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.computer.infectedComputer);
        attacker.attack();

        model.computer.infectedComputer.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new dataFromLocalSystem();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.dataFromLocalSystem);
        attacker.attack();

        //model.os.userCommandLineInterface.assertCompromisedInstantaneously();
        //model.os.adminCommandLineInterface.assertCompromisedInstantaneously();
        model.os.dataCollected.assertCompromisedInstantaneously();
    }
}