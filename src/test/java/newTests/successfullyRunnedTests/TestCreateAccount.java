package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestCreateAccount extends EnterpriseLangTest {
    
    public static class createAccount {

        public final AdminAccount adminAccount = new AdminAccount("adminAccount");
        public final OS os = new OS("os");

        public createAccount(){
            adminAccount.addOs(os);
        }
    }

    @Test
    public void infectedOS(){
        var model = new createAccount();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.adminAccount.attemptCreateAccount);
        attacker.attack();

        //model.os.accountDiscovery.assertCompromisedInstantaneously();
        model.adminAccount.attemptCreateAccount.assertCompromisedInstantaneously();
        }
    }