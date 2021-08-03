package org.mal_lang.enterpriselang.test;

import core.Attacker;
import org.junit.jupiter.api.Test;

public class TestDataFromNetworkSharedDrive extends EnterpriseLangTest {

    private static class dataFromNetworkSharedDrive {
        public final OS os = new OS("os");
        public final InternalNetwork internalNetwork = new InternalNetwork("internalNetwork");
        public final NetworkSharedDrive networkSharedDrive = new NetworkSharedDrive("networkSharedDrive");   
    }

    @Test
    public void infectedOS(){
        var model = new dataFromNetworkSharedDrive();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.os.sensitiveDataCollected);
        attacker.attack();

        model.os.sensitiveDataCollected.assertCompromisedInstantaneously();
    }

      @Test
    public void internalNetwork(){
        var model = new dataFromNetworkSharedDrive();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.internalNetwork.remoteSystemsConnection);
        attacker.attack();

        model.internalNetwork.remoteSystemsConnection.assertCompromisedInstantaneously();
    }

      @Test
    public void networkSharedDrive(){
        var model = new dataFromNetworkSharedDrive();

        Attacker attacker = new Attacker();
        attacker.addAttackPoint(model.networkSharedDrive.dataFromNetworkSharedDrive);
        attacker.attack();

        model.networkSharedDrive.dataFromNetworkSharedDrive.assertCompromisedInstantaneously();
    }
}