package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestClipboardData extends EnterpriseLangTest {

    private static class clipboardData {
        public final UserAccount userAccount = new UserAccount("userAccount");
        public final OS os = new OS("os");

        
    }
    
    @Test
    public void infectedOS(){
        var model = new clipboardData();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.userAccount.userRights.assertCompromisedInstantaneously();
        model.os.resourceHijacking.assertCompromisedInstantaneously();
        model.userAccount.userCredentials.assertCompromisedInstantaneously();
       // model.userAccount.adminLogin.assertCompromisedInstantaneously();
    }
/*

    @Test
    public void userCredentials(){
        var model = new clipboardData();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userCredentials);
        attacker.attack();

        model.userAccount.userCredentials.assertCompromisedInstantaneously();
    }*/
/*
    @Test
    public void infectedOS(){
        var model = new clipboardData();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.userAccount.userRights);
        attacker.attack();

        model.os.clipboardData.assertCompromisedInstantaneously();
    }*/
}