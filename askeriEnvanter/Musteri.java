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
public class Musteri {
    private Long musteri_id;
    private String musteri_isim;
    private String musteri_ulke;
    private int silah_id;
    private int adet;
    private Silahlar silahlar;
 

    public Musteri(Long musteri_id, String musteri_isim, String musteri_ulke, int silah_id, int adet, Silahlar silahlar) {
        this.musteri_id = musteri_id;
        this.musteri_isim = musteri_isim;
        this.musteri_ulke = musteri_ulke;
        this.silah_id = silah_id;
        this.adet = adet;
        this.silahlar = silahlar;
    }
        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Musteri(String name) {
        this.name = name;
    }


    public Musteri() {
    }

    public Long getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(Long musteri_id) {
        this.musteri_id = musteri_id;
    }

    public String getMusteri_isim() {
        return musteri_isim;
    }

    public void setMusteri_isim(String musteri_isim) {
        this.musteri_isim = musteri_isim;
    }

    public String getMusteri_ulke() {
        return musteri_ulke;
    }

    public void setMusteri_ulke(String musteri_ulke) {
        this.musteri_ulke = musteri_ulke;
    }

    public int getSilah_id() {
        return silah_id;
    }

    public void setSilah_id(int silah_id) {
        this.silah_id = silah_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Silahlar getSilahlar() {
        return silahlar;
    }

    public void setSilahlar(Silahlar silahlar) {
        this.silahlar = silahlar;
    }
    
    //mediator;
    
    public void gönderMesaj(String message) {
        firmaa.onayMesaj(this, message);
    }

    @Override
    public String toString() {
        return "Musteri{" + "musteri_id=" + musteri_id + ", musteri_isim=" + musteri_isim + ", musteri_ulke=" + musteri_ulke + ", silah_id=" + silah_id + ", adet=" + adet + ", silahlar=" + silahlar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.musteri_id);
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
        final Musteri other = (Musteri) obj;
        if (!Objects.equals(this.musteri_id, other.musteri_id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
