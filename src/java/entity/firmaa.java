/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Onur
 */
public class firmaa {
      public static void onayMesaj(Musteri musteri, String message) {
        System.out.println(new Date().toString() + " [" + musteri.getName() + "] : " + message);
    }
}
