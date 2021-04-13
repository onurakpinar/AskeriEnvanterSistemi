/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Tur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onur
 */
public class TurDAO extends DAO {

    private SilahlarDAO silahlarDAO;

    public SilahlarDAO getSilahlarDAO() {
        if (silahlarDAO == null) {
            silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

    public void ekle(Tur tur) {
        try {
            PreparedStatement pst = getConn().prepareStatement("insert into tur(tur_id,silah_id,kara,hava,deniz) values (default,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, tur.getSilahlar().getSilah_id());
            pst.setString(2, tur.getKara());
            pst.setString(3, tur.getHava());
            pst.setString(4, tur.getDeniz());
            pst.executeUpdate();

            ResultSet gk = pst.getGeneratedKeys();
            Long tur_id = null;
            if (gk.next()) {
                tur_id = gk.getLong(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sil(Tur tur) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from tur where tur_id=?");
            pst.setLong(1, tur.getTur_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Tur tur) {
        try {
            PreparedStatement pst = getConn().prepareStatement("update tur set silah_id=?,kara=?,hava=?,deniz=? where tur_id=?");
            pst.setLong(1, tur.getSilahlar().getSilah_id());
            pst.setString(2, tur.getKara());
            pst.setString(3, tur.getHava());
            pst.setString(4, tur.getDeniz());
            pst.setLong(5, tur.getTur_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Tur find(Long id) {
        Tur tu = null;
        String query = ("select * from tur where tur_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();
            tu = new Tur();
            tu.setTur_id(rs.getLong("tur_id"));
            
            tu.setKara(rs.getString("kara"));
            tu.setHava(rs.getString("hava"));
            tu.setDeniz(rs.getString("deniz"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tu;

    }
       public List<Tur> findAll() {
        List<Tur> dList = new ArrayList<>();
        try {
            PreparedStatement pst = this.getConn().prepareStatement("select*from tur");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Tur d = new Tur();
                d.setTur_id(rs.getLong("tur_id"));
                
                d.setKara(rs.getString("kara"));
                d.setHava(rs.getString("hava"));
                d.setDeniz(rs.getString("deniz"));
                dList.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dList;
    }


    public List<Tur> hepsiniOku(int page, int pageSize) {
        List<Tur> flist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from tur order by tur_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Tur tmp = new Tur();
                tmp.setTur_id(rs.getLong("tur_id"));
                tmp.setSilahlar(this.getSilahlarDAO().find(rs.getLong("silah_id")));
                tmp.setKara(rs.getString("kara"));
                tmp.setHava(rs.getString("hava"));
                tmp.setDeniz(rs.getString("deniz"));
                flist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(tur_id) as tur_count from tur ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("tur_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
