package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestKeyChain extends EnterpriseLangTest {

    private static class keyChain {
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        
        public keyChain() {
            adminAccount.addOs(os);
            userAccount.addOs(os);

        }
    }

    @Test
    public void userRights(){
        var model = new keyChain();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

    }
}