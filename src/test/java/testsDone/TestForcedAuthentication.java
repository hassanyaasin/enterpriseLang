package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestForcedAuthentication extends EnterpriseLangTest {
    private static class forcedAuthentication{
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Computer computer = new Computer("computer");

        public forcedAuthentication(){
            userAccount.addOs(os);
            computer.addOs(os);
        }
    }

    @Test
    public void userRights(){
        var model = new forcedAuthentication();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.forcedAuthentication.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new forcedAuthentication();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.bruteForce.assertCompromisedInstantaneously();
        model.os.forcedAuthentication.assertCompromisedInstantaneously();
        model.os.domainDiscovery.assertCompromisedInstantaneously();
    }
}