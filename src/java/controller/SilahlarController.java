/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DocumentDAO;
import dao.SilahlarDAO;
import dao.TurDAO;
import entity.Document;
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
public class SilahlarController implements Serializable {

    private List<Silahlar> sslist;
    private SilahlarDAO sdao;
    private Silahlar silahlar;
    private List<Document> doList;
    private DocumentDAO documentDAO;
    private List<Tur> tuList;
    private TurDAO turDAO;

    public SilahlarController(List<Silahlar> sslist, SilahlarDAO sdao, Silahlar silahlar, List<Document> doList, DocumentDAO documentDAO, List<Tur> tuList, TurDAO turDAO, int pageCount) {
        this.sslist = sslist;
        this.sdao = sdao;
        this.silahlar = silahlar;
        this.doList = doList;
        this.documentDAO = documentDAO;
        this.tuList = tuList;
        this.turDAO = turDAO;
        this.pageCount = pageCount;
    }

    public SilahlarController(List<Silahlar> sslist, SilahlarDAO sdao, Silahlar silahlar, List<Document> doList, DocumentDAO documentDAO, int pageCount) {
        this.sslist = sslist;
        this.sdao = sdao;
        this.silahlar = silahlar;
        this.doList = doList;
        this.documentDAO = documentDAO;
        this.pageCount = pageCount;
    }
    



    public List<Tur> getTuList() {
        this.tuList = this.getTurDAO().findAll();
        return tuList;
    }

    public void setTuList(List<Tur> tuList) {
        this.tuList = tuList;
    }

    public TurDAO getTurDAO() {
        if (this.turDAO == null) {
            this.turDAO = new TurDAO();

        }
        return turDAO;
    }

    public List<Document> getDoList() {
        this.doList = this.getDocumentDAO().findAll();
        return doList;
    }

    public void setDoList(List<Document> doList) {
        this.doList = doList;
    }

    public DocumentDAO getDocumentDAO() {
        if (this.documentDAO == null) {
            this.documentDAO = new DocumentDAO();

        }
        return documentDAO;
    }

    private int page = 1;
    private int pageSize = 6;
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
        this.pageCount = (int) Math.ceil(this.getSdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public SilahlarController() {
    }

    public SilahlarController(List<Silahlar> sslist, SilahlarDAO sdao) {
        this.sslist = sslist;
        this.sdao = sdao;
    }

    public void guncelleForm(Silahlar silah) {
        this.silahlar = silah;
    }

    public void silBilgi(Silahlar silah) {
        this.silahlar = silah;
    }

    public void clearForm() {
        this.silahlar = new Silahlar();

    }

    public void guncelle() {
        this.getSdao().guncelle(this.silahlar);
        this.silahlar = new Silahlar();
    }

    public void sil() {
        this.getSdao().sil(this.silahlar);
        this.silahlar = new Silahlar();

    }

    public void create() {
        this.getSdao().ekle(this.silahlar);
        this.silahlar = new Silahlar();
    }

    public List<Silahlar> getSslist() {
        this.sslist = getSdao().hepsiniOku(page, pageSize);
        return sslist;
    }

    public void setSslist(List<Silahlar> sslist) {
        this.sslist = sslist;
    }

    public SilahlarDAO getSdao() {
        if (this.sdao == null) {
            this.sdao = new SilahlarDAO();
        }
        return sdao;
    }

    public void setSdao(SilahlarDAO sdao) {
        this.sdao = sdao;
    }

    public Silahlar getSilahlar() {
        if (this.silahlar == null) {
            this.silahlar = new Silahlar();
        }
        return silahlar;
    }

    public void setSilahlar(Silahlar silahlar) {
        this.silahlar = silahlar;
    }

}
