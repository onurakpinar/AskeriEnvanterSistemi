/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.uyeDAO;
import entity.uye;
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
public class uyeController implements Serializable {

    private List<uye> ulist;
    private uyeDAO udao;
    private uye Uye;
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
        this.pageCount = (int) Math.ceil(this.getUdao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public uyeController() {
    }

    public uyeController(List<uye> ulist, uyeDAO udao) {
        this.ulist = ulist;
        this.udao = udao;
    }

    public void guncelleForm(uye uye) {
        this.Uye = uye;
    }

    public void silBilgi(uye uye) {
        this.Uye = uye;
    }

    public void clearForm() {
        this.Uye = new uye();

    }

    public void guncelle() {
        this.getUdao().guncelle(this.Uye);
        this.Uye = new uye();
    }

    public void sil() {
        this.getUdao().sil(this.Uye);
        this.Uye = new uye();

    }

    public String create() {
        this.getUdao().ekle(this.Uye);
        this.Uye = new uye();
        return "/index.xhtml";
    }

    public List<uye> getUlist() {
        this.ulist = getUdao().hepsiniOku(page, pageSize);
        return ulist;
    }

    public void setUlist(List<uye> ulist) {
        this.ulist = ulist;
    }

    public uyeDAO getUdao() {
        if (this.udao == null) {
            this.udao = new uyeDAO();
        }
        return udao;
    }

    public void setsetUdao(uyeDAO udao) {
        this.udao = udao;
    }

    public uye getUye() {
        if (this.Uye == null) {
            this.Uye = new uye();
        }
        return Uye;
    }

    public void setUye(uye Uye) {
        this.Uye = Uye;
    }

}
