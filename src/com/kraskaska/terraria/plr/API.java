package com.kraskaska.terraria.plr;

import one.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.awt.*;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static one.Main.printInventoryItem;
import static one.Main.printItem;

/**
 * Easy to use API for modifying PLR files
 *
 * @author Kraskaska
 * @version 1.2
 */
public class API {
    private ReadPlayerData playerData;
    private int[] decryptedData;
    private Data data;
//    public static void main(String[] args) throws Exception {
//        API api = new API(Paths.get("Player.plr").toString());
//    }
    public API(String fileName) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        ExtractPlayerData ePD = new ExtractPlayerData();
        playerData = new ReadPlayerData();

        // Decryption Key
        byte[] pass = {104, 0, 51, 0, 121, 0, 95, 0, 103, 0, 85, 0, 121, 0, 90, 0};
        byte[] data = ePD.ExtractRawData(fileName);
        byte[] decrypted = ePD.DecryptRawData(data, pass);

        System.out.println("[API] Decryption successful.");

        decryptedData = new int[decrypted.length];
        for (int i = 0; i < decrypted.length; i++) {
            decryptedData[i] = decrypted[i] & 0xFF;
        }
        this.data = new Data(this.playerData, decryptedData);
        System.out.println("[API] Name: '"+this.data.readPlayerName()+"', Terraria Version: "+this.data.readVersion());
    }

    /**
     * Wrapper for easing of access
     * @author Kraskaska
     * @version 1.2
     */
    public class Data extends ReadPlayerData{
        private ReadPlayerData readPlayerData;
        private int[] decryptedData;
        private Data(ReadPlayerData data, int[] decryptedData){
            this.readPlayerData = data;
            this.decryptedData = decryptedData;
        }

        /**
         * @return Terraria version
         */
        public int readVersion(){
            return readPlayerData.readVersion(decryptedData);
        }

        /**
         * @return Player name
         */
        public String readPlayerName(){
            return readPlayerData.readPlayerName(decryptedData);
        }

//        public Buff[] readBuffs(){
//            int offset = 2309+readPlayerName().length();
//            return super.readBuffs(decryptedData, offset);
//        }
    }
}
