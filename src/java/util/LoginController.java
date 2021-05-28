/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.uyeDAO;
import entity.uye;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Onur
 */
@Named
@SessionScoped
public class LoginController implements Serializable {

    private uyeDAO udao;
    private uye uye;

    public String login() {
        uye = getUdao().girisYap(this.uye.getEmail(), this.uye.getSifre());
        if (this.uye != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.uye);
            return "/temp";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalali kullanici adi veya sifre"));
            return "/index";
        }
    }

    public uyeDAO getUdao() {
        return udao == null ? udao = new uyeDAO() : udao;
    }

    public uye getUye() {
        return uye == null ? uye = new uye() : uye;
    }

    public void setUye(uye uye) {
        this.uye = uye;
    }

}
