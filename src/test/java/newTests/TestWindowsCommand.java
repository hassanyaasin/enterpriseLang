package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestWindowsCommand extends EnterpriseLangTest {
    private static class WindowsCommandModel {

        /*
        attack scenario source: https://us-cert.cisa.gov/ncas/alerts/TA18-086A

                                        
               UserAccount -- OS -- Windows 

        Attacker's entry point: UserAccount.userRights
        */

        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os"); // We assume all defenses are disabled for OS. We can enable some of them, then the corresponding attack steps can not be reached.  
        public final Windows windows = new Windows("windows");

        public WindowsCommandModel() {
            os.addUserAccount(userAccount);
        }
    }

    @Test 
    public void testWindowsCommand() {
            var model = new WindowsCommandModel();

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(model.userAccount.userRights);
            attacker.attack();

            model.os.commandAndScriptingInterpreter.assertCompromisedInstantaneously();
            model.windows.commandAndScriptingInterpreter.assertCompromisedInstantaneously();
            model.windows.unixShell.assertCompromisedInstantaneously();
    }  
}