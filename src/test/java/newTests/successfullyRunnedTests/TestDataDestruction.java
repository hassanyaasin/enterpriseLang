package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDataDestruction extends EnterpriseLangTest {

    private static class dataDestruction {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final Computer computer = new Computer("computer");
        public final OS os = new OS("os");

        public dataDestruction() {
            userAccount.addOs(os);
            adminAccount.addOs(os);
            computer.addOs(os);
        }
    }

    @Test
    public void userRights(){
        var model = new dataDestruction();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void adminRights(){
        var model = new dataDestruction();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.adminRights);
        attacker.attack();

        model.adminAccount.adminRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedComputer(){
        var model = new dataDestruction();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.attemptDataDestruction);
        attacker.attack();

        model.os.dataDestruction.assertCompromisedInstantaneously();
    }
}