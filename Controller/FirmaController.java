/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FirmaDAO;
import dao.SilahlarDAO;
import entity.Firma;
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
public class FirmaController implements Serializable {

    private List<Firma> fList;
    private FirmaDAO fdao;
    private Firma firma;
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

    public FirmaController(List<Firma> fList, FirmaDAO fdao, Firma firma, List<Silahlar> silahlarList, SilahlarDAO silahlarDAO, int pageCount) {
        this.fList = fList;
        this.fdao = fdao;
        this.firma = firma;
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
        this.pageCount = (int) Math.ceil(this.getFdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public FirmaController() {
    }

    public void guncelleForm(Firma firma) {
        this.firma = firma;

    }

    public void silBilgi(Firma firma) {
        this.firma = firma;
    }

    public void clearForm() {
        this.firma = new Firma();

    }

    public void guncelle() {
        this.getFdao().guncelle(this.firma);
        this.clearForm();
    }

    public void sil() {
        this.getFdao().sil(this.firma);
        this.firma = new Firma();

    }

    public void create() {
        this.getFdao().ekle(this.firma);
        this.firma = new Firma();

    }

    public Firma getFirma() {
        if (this.firma == null) {
            this.firma = new Firma();
        }

        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public FirmaController(List<Firma> flist, FirmaDAO fdao) {
        this.fList = flist;
        this.fdao = fdao;
    }

    public List<Firma> getFlist() {
        this.fList = this.getFdao().hepsiniOku(page, pageSize);
        return fList;
    }

    public void setFlist(List<Firma> fList) {
        this.fList = fList;
    }

    public FirmaDAO getFdao() {
        if (this.fdao == null) {
            this.fdao = new FirmaDAO();
        }

        return fdao;
    }

    public void setFdao(FirmaDAO fdao) {
        this.fdao = fdao;
    }

}
