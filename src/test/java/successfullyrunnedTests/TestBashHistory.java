package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestBashHistory extends EnterpriseLangTest {
      private static class bashHistory {
        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Linux linux = new Linux("linux");
        public final MacOS macOS = new MacOS("macOS");
        
        public bashHistory() {
            adminAccount.addOs(os);
            userAccount.addOs(os);

        }
    }

    @Test
    public void userRights(){
        var model = new bashHistory();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.bashHistory.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedOS(){
        var model = new bashHistory();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.bashHistory.assertCompromisedInstantaneously();
    }
}