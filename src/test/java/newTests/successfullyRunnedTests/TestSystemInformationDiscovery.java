package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestSystemInformationDiscovery extends EnterpriseLangTest {

    private static class systemInformationDiscovery {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");

        public systemInformationDiscovery() {
            userAccount.addOs(os);
        }
    }

    @Test
    public void infectedOS(){
        var model = new systemInformationDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.systemInformationDiscovery);
        attacker.attack();

        model.os.systemInformationDiscovery.assertCompromisedInstantaneously();
    }
}