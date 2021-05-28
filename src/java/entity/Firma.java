/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Onur
 */
public class Firma {

    private Long firma_id;
    private String firma_ismi;
    private String firma_ulke;
    private int silah_id;
    private Silahlar silahlar;

    public Firma(Long firma_id, String firma_ismi, String firma_ulke, int silah_id, Silahlar silahlar) {
        this.firma_id = firma_id;
        this.firma_ismi = firma_ismi;
        this.firma_ulke = firma_ulke;
        this.silah_id = silah_id;
        this.silahlar = silahlar;
    }
    
    public Firma(){
        
    }

    public Long getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(Long firma_id) {
        this.firma_id = firma_id;
    }

    public String getFirma_ismi() {
        return firma_ismi;
    }

    public void setFirma_ismi(String firma_ismi) {
        this.firma_ismi = firma_ismi;
    }

    public String getFirma_ulke() {
        return firma_ulke;
    }

    public void setFirma_ulke(String firma_ulke) {
        this.firma_ulke = firma_ulke;
    }

    public int getSilah_id() {
        return silah_id;
    }

    public void setSilah_id(int silah_id) {
        this.silah_id = silah_id;
    }

    public Silahlar getSilahlar() {
        return silahlar;
    }

    public void setSilahlar(Silahlar silahlar) {
        this.silahlar = silahlar;
    }
    
    //mediator
        public static void onayMesaj(Musteri musteri, String message) {
        System.out.println(new Date().toString() + " [" + musteri.getName() + "] : " + message);
    }

    @Override
    public String toString() {
        return "Firma{" + "firma_id=" + firma_id + ", firma_ismi=" + firma_ismi + ", firma_ulke=" + firma_ulke + ", silah_id=" + silah_id + ", silahlar=" + silahlar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.firma_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Firma other = (Firma) obj;
        if (!Objects.equals(this.firma_id, other.firma_id)) {
            return false;
        }
        return true;
    }
    
    

}
