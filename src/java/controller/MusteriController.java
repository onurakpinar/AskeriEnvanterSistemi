/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MusteriDAO;
import dao.SilahlarDAO;
import entity.Musteri;
import entity.Silahlar;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Onur
 */
@Named
@SessionScoped
public class MusteriController implements Serializable {

    private List<Musteri> mList;
    private MusteriDAO mdao;
    private Musteri musteri;
    private List<Silahlar> silahlarList;
    private SilahlarDAO silahlarDAO;

    public List<Silahlar> getSilahlarList() {
        this.silahlarList = this.getSilahlarDAO().hepsiniOku();
        return silahlarList;
    }

    public void setSilahlarList(List<Silahlar> silahlarList) {
        this.silahlarList = silahlarList;
    }

    public SilahlarDAO getSilahlarDAO() {
        if (silahlarDAO == null) {
            silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

    public MusteriController(List<Musteri> mList, MusteriDAO mdao, Musteri musteri, List<Silahlar> silahlarList, SilahlarDAO silahlarDAO, int pageCount) {
        this.mList = mList;
        this.mdao = mdao;
        this.musteri = musteri;
        this.silahlarList = silahlarList;
        this.silahlarDAO = silahlarDAO;
        this.pageCount = pageCount;
    }

    private int page = 1;
    private int pageSize = 4;
    private int pageCount;

    public void ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
        this.clearForm();
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
        this.clearForm();
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getMdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public MusteriController() {
    }

    public void guncelleForm(Musteri musteri) {
        this.musteri = musteri;

    }

    public void silBilgi(Musteri musteri) {
        this.musteri = musteri;
    }

    public void clearForm() {
        this.musteri = new Musteri();

    }

    public void guncelle() {
        this.getMdao().guncelle(this.musteri);
        this.clearForm();
    }

    public void sil() {
        this.getMdao().sil(this.musteri);
        this.musteri = new Musteri();

    }

    public void create() {
        this.getMdao().ekle(this.musteri);
        this.musteri = new Musteri();

    }

    public Musteri getMusteri() {
        if (this.musteri == null) {
            this.musteri = new Musteri();
        }

        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public MusteriController(List<Musteri> mlist, MusteriDAO mdao) {
        this.mList = mlist;
        this.mdao = mdao;
    }

    public List<Musteri> getMlist() {
        this.mList = this.getMdao().hepsiniOku(page, pageSize);
        return mList;
    }

    public void setMlist(List<Musteri> mlist) {
        this.mList = mlist;
    }

    public MusteriDAO getMdao() {
        if (this.mdao == null) {
            this.mdao = new MusteriDAO();
        }

        return mdao;
    }

    public void setMdao(MusteriDAO mdao) {
        this.mdao = mdao;
    }

}
