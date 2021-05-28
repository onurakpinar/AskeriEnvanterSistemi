/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;

/**
 *
 * @author Onur
 */
public class Tur implements Silah {

    private Long tur_id;
    private int silah_id;
    private String kara;
    private String hava;
    private String deniz;
    private Silahlar silahlar;

    public Tur(Long tur_id, int silah_id, String kara, String hava, String deniz, Silahlar silahlar) {
        this.tur_id = tur_id;
        this.silah_id = silah_id;
        this.kara = kara;
        this.hava = hava;
        this.deniz = deniz;
        this.silahlar = silahlar;
    }

    public Tur() {

    }

    public Long getTur_id() {
        return tur_id;
    }

    public void setTur_id(Long tur_id) {
        this.tur_id = tur_id;
    }

    public int getSilah_id() {
        return silah_id;
    }

    public void setSilah_id(int silah_id) {
        this.silah_id = silah_id;
    }

    public String getKara() {
        return kara;
    }

    public void setKara(String kara) {
        this.kara = kara;
    }

    public String getHava() {
        return hava;
    }

    public void setHava(String hava) {
        this.hava = hava;
    }

    public String getDeniz() {
        return deniz;
    }

    public void setDeniz(String deniz) {
        this.deniz = deniz;
    }

    public Silahlar getSilahlar() {
        return silahlar;
    }

    public void setSilahlar(Silahlar silahlar) {
        this.silahlar = silahlar;
    }
//overide yapıyor factoryy methodunu almak için 
    @Override
    public String getTip() {
        return "Kara"+kara+"Hava"+hava+"Deniz"+deniz;
    }

    @Override
    public String toString() {
        return "Tur{" + "tur_id=" + tur_id + ", silah_id=" + silah_id + ", kara=" + kara + ", hava=" + hava + ", deniz=" + deniz + ", silahlar=" + silahlar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.tur_id);
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
        final Tur other = (Tur) obj;
        if (!Objects.equals(this.tur_id, other.tur_id)) {
            return false;
        }
        return true;
    }

}
