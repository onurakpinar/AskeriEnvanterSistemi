/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.SilahlarDAO;
import dao.TurDAO;
import entity.Silahlar;
import entity.Tur;
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
public class TurController implements Serializable {

    private List<Tur> tList;
    private TurDAO tdao;
    private Tur tur;
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

    public TurController(List<Tur> tList, TurDAO tdao, Tur tur, List<Silahlar> silahlarList, SilahlarDAO silahlarDAO, int pageCount) {
        this.tList = tList;
        this.tdao = tdao;
        this.tur = tur;
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
        this.pageCount = (int) Math.ceil(this.getTdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public TurController() {
    }

    public void guncelleForm(Tur tur) {
        this.tur = tur;

    }

    public void silBilgi(Tur tur) {
        this.tur = tur;
    }

    public void clearForm() {
        this.tur = new Tur();

    }

    public void guncelle() {
        this.getTdao().guncelle(this.tur);
        this.clearForm();
    }

    public void sil() {
        this.getTdao().sil(this.tur);
        this.tur = new Tur();

    }

    public void create() {
        this.getTdao().ekle(this.tur);
        this.tur = new Tur();

    }

    public Tur getTur() {
        if (this.tur == null) {
            this.tur = new Tur();
        }

        return tur;
    }

    public void setTur(Tur tur) {
        this.tur = tur;
    }

    public TurController(List<Tur> tlist, TurDAO tdao) {
        this.tList = tlist;
        this.tdao = tdao;
    }

    public List<Tur> getTlist() {
        this.tList = this.getTdao().hepsiniOku(page, pageSize);
        return tList;
    }

    public void setTlist(List<Tur> tlist) {
        this.tList = tlist;
    }

    public TurDAO getTdao() {
        if (this.tdao == null) {
            this.tdao = new TurDAO();
        }

        return tdao;
    }

    public void setTdao(TurDAO tdao) {
        this.tdao = tdao;
    }

}
