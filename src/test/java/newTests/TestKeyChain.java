package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestKeyChain extends EnterpriseLangTest {

    private static class keyChain {
        public final Administrator administrator = new Administrator("administrator");
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        
        public keyChain() {
            administrator.addOs(os);
            userAccount.addOs(os);

        }
    }

    @Test
    public void userRights(){
        var model = new accountDiscovery();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

    }
}