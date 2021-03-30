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
public class Envanter {

    private Long envanter_id;
    private int silah_id;
    private String envanter_isim;
    private int adet;
    private Silahlar silahlar;

    public Silahlar getSilahlar() {
        return silahlar;
    }

    public void setSilahlar(Silahlar silahlar) {
        this.silahlar = silahlar;
    }

    public int getSilah_id() {
        return silah_id;
    }

    public void setSilah_id(int silah_id) {
        this.silah_id = silah_id;
    }

    public Envanter(Long envanter_id, int silah_id, String envanter_isim, int adet, Silahlar silahlar) {
        this.envanter_id = envanter_id;
        this.silah_id = silah_id;
        this.envanter_isim = envanter_isim;
        this.adet = adet;
        this.silahlar = silahlar;
    }

    public Envanter() {
    }

    public Long getEnvanter_id() {
        return envanter_id;
    }

    public void setEnvanter_id(Long envanter_id) {
        this.envanter_id = envanter_id;
    }

    public String getEnvanter_isim() {
        return envanter_isim;
    }

    public void setEnvanter_isim(String envanter_isim) {
        this.envanter_isim = envanter_isim;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    @Override
    public String toString() {
        return "Envanter{" + "envanter_id=" + envanter_id + ", silah_id=" + silah_id + ", envanter_isim=" + envanter_isim + ", adet=" + adet + ", silahlar=" + silahlar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.envanter_id);
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
        final Envanter other = (Envanter) obj;
        if (!Objects.equals(this.envanter_id, other.envanter_id)) {
            return false;
        }
        return true;
    }

}
