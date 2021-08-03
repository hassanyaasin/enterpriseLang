package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestCredentialsFromWebBrowsers extends EnterpriseLangTest {

    private static class credentialsFromWebBrowsers {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Browser browser = new Browser();
        
        public credentialsFromWebBrowsers() {
            userAccount.addOs(os);
        }
    }

    @Test
    public void userRights(){
        var model = new credentialsFromWebBrowsers();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.browser.credentialsFromWebBrowsers.assertCompromisedInstantaneously();
    }

    @Test
    public void userCredentials(){
        var model = new credentialsFromWebBrowsers();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userCredentials);
        attacker.attack();

        model.userAccount.userCredentials.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedBrowser(){
        var model = new credentialsFromWebBrowsers();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.credentialsFromWebBrowsers);
        attacker.attack();

        model.browser.credentialsFromWebBrowsers.assertCompromisedInstantaneously();
    }

}