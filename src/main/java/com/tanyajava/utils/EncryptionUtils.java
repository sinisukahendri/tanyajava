/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tanyajava.utils;

import java.util.Scanner;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 *
 * @author ifnu
 */
public class EncryptionUtils {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        System.out.print("Please password for encryptor : ");
        String password = in.nextLine();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(password);
        while(true){
            System.out.print("Please input plain text : ");
            String plainText = in.nextLine();
            System.out.println("Encrypted valie : " + encryptor.encrypt(plainText));
            System.out.print("Encrypt more text?[Y/N] : ");
            String more = in.nextLine();
            if(!"Y".equalsIgnoreCase(more)){
                break;
            }
        }
    }
}
