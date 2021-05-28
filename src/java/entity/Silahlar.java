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
public class Silahlar {

    private Long silah_id;
    private String silah_isim;
    private int uretim_yili;
    private int document_id;
    private Document document;
    private Tur tur;
    private String turr;

    public Silahlar(Long silah_id, String silah_isim, int uretim_yili, int document_id, Document document, Tur tur, String turr) {
        this.silah_id = silah_id;
        this.silah_isim = silah_isim;
        this.uretim_yili = uretim_yili;
        this.document_id = document_id;
        this.document = document;
        this.tur = tur;
        this.turr = turr;
    }

    public String getTurr() {
        return turr;
    }

    public void setTurr(String turr) {
        this.turr = turr;
    }



    public Silahlar() {

    }
  

    public Long getSilah_id() {
        return silah_id;
    }

    public void setSilah_id(Long silah_id) {
        this.silah_id = silah_id;
    }

    public String getSilah_isim() {
        return silah_isim;
    }

    public void setSilah_isim(String silah_isim) {
        this.silah_isim = silah_isim;
    }

    public int getUretim_yili() {
        return uretim_yili;
    }

    public void setUretim_yili(int uretim_yili) {
        this.uretim_yili = uretim_yili;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Tur getTur() {
        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }

    @Override
    public String toString() {
        return "Silahlar{" + "silah_id=" + silah_id + ", silah_isim=" + silah_isim + ", uretim_yili=" + uretim_yili + ", document_id=" + document_id + ", document=" + document + ", tur=" + tur + ", turr=" + turr + '}';
    }

  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.silah_id);
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
        final Silahlar other = (Silahlar) obj;
        if (!Objects.equals(this.silah_id, other.silah_id)) {
            return false;
        }
        return true;
    }

}
