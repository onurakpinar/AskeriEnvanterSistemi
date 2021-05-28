/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.SilahlarDAO;
import entity.Silahlar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Onur
 */
@FacesConverter("silahlarConverter")
public class SilahlarConverter implements Converter {

    private SilahlarDAO silahlarDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        return this.getSilahlarDAO().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object arg2) {
        Silahlar s = (Silahlar) arg2;
        return s.getSilah_id().toString();
    }

    public SilahlarDAO getSilahlarDAO() {
        if (this.silahlarDAO == null) {
            this.silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

}
