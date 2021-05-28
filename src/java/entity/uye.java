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
public class uye {

    private Long uye_id;
    private String adı;
    private String soyadı;
    private String email;
    private String sifre;
    private boolean admin;

    public uye(Long uye_id, String adı, String soyadı, String email, String sifre, boolean admin) {
        this.uye_id = uye_id;
        this.adı = adı;
        this.soyadı = soyadı;
        this.email = email;
        this.sifre = sifre;
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Long getUye_id() {
        return uye_id;
    }

    public void setUye_id(Long uye_id) {
        this.uye_id = uye_id;
    }

    public String getAdı() {
        return adı;
    }

    public void setAdı(String adı) {
        this.adı = adı;
    }

    public String getSoyadı() {
        return soyadı;
    }

    public void setSoyadı(String soyadı) {
        this.soyadı = soyadı;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public uye() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.uye_id);
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
        final uye other = (uye) obj;
        if (!Objects.equals(this.uye_id, other.uye_id)) {
            return false;
        }
        return true;
    }

}
