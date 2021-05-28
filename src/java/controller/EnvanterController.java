/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EnvanterDAO;
import dao.SilahlarDAO;
import entity.Envanter;
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
public class EnvanterController implements Serializable {

    private List<Envanter> eList;
    private EnvanterDAO edao;
    private Envanter envanter;
    private List<Silahlar> silahlarList;
    private SilahlarDAO silahlarDAO;

    

    public EnvanterController(List<Envanter> eList, EnvanterDAO edao, Envanter envanter, List<Silahlar> silahlarList, SilahlarDAO silahlarDAO, int pageCount) {
        this.eList = eList;
        this.edao = edao;
        this.envanter = envanter;
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
        this.pageCount = (int) Math.ceil(this.getEdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public EnvanterController() {
    }

    public void guncelleForm(Envanter envanter) {
        this.envanter = envanter;

    }

    public void silBilgi(Envanter envanter) {
        this.envanter = envanter;
    }

    public void clearForm() {
        this.envanter = new Envanter();

    }

    public void guncelle() {
        this.getEdao().guncelle(this.envanter);
        this.clearForm();
    }

    public void sil() {
        this.getEdao().sil(this.envanter);
        this.envanter = new Envanter();

    }

    public void create() {
        this.getEdao().ekle(this.envanter);
        this.envanter = new Envanter();

    }

    public Envanter getEnvanter() {
        if (this.envanter == null) {
            this.envanter = new Envanter();
        }

        return envanter;
    }

    public void setEnvanter(Envanter envanter) {
        this.envanter = envanter;
    }

    public EnvanterController(List<Envanter> elist, EnvanterDAO edao) {
        this.eList = elist;
        this.edao = edao;
    }

    public List<Envanter> getElist() {
        this.eList = this.getEdao().hepsiniOku(page, pageSize);
        return eList;
    }

    public void setElist(List<Envanter> elist) {
        this.eList = elist;
    }

    public EnvanterDAO getEdao() {
        if (this.edao == null) {
            this.edao = new EnvanterDAO();
        }

        return edao;
    }

    public void setEdao(EnvanterDAO edao) {
        this.edao = edao;
    }
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

}
