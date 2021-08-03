package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestStealWebSessionCookie extends EnterpriseLangTest {

    private static class stealWebSessionCookie {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");
        public final Browser browser = new Browser("browser");
    }

    @Test
    public void userRights(){
        var model = new stealWebSessionCookie();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
    }

    @Test
    public void infectedBrowser(){
        var model = new stealWebSessionCookie();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.browser.stealWebSessionCookie);
        attacker.attack();

        model.browser.stealWebSessionCookie.assertCompromisedInstantaneously();
        model.browser.webSessionCookie.assertCompromisedInstantaneously();
    }
}