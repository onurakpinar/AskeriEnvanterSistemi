/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Firma;
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
public class FirmaDAO extends DAO {

    private SilahlarDAO silahlarDAO;

    public SilahlarDAO getSilahlarDAO() {
        if (silahlarDAO == null) {
            silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

    public void ekle(Firma firma) {
        try {
            PreparedStatement pst = getConn().prepareStatement("insert into firma(firma_id,firma_ismi,firma_ulke,silah_id) values (default,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, firma.getFirma_ismi());
            pst.setString(2, firma.getFirma_ulke());
            pst.setLong(3, firma.getSilahlar().getSilah_id());

            pst.executeUpdate();

            ResultSet gk = pst.getGeneratedKeys();
            Long firma_id = null;
            if (gk.next()) {
                firma_id = gk.getLong(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sil(Firma firma) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from firma where firma_id=?");
            pst.setLong(1, firma.getFirma_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Firma firma) {
        try {
            PreparedStatement pst = getConn().prepareStatement("update firma set firma_ismi=?,firma_ulke=?,silah_id=? where firma_id=?");
            pst.setString(1, firma.getFirma_ismi());
            pst.setString(2, firma.getFirma_ulke());
            pst.setLong(3, firma.getSilahlar().getSilah_id());
            pst.setLong(4, firma.getFirma_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Firma> hepsiniOku(int page, int pageSize) {
        List<Firma> flist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from firma order by firma_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Firma tmp = new Firma();
                tmp.setFirma_id(rs.getLong("firma_id"));
                tmp.setFirma_ismi(rs.getString("firma_ismi"));
                tmp.setFirma_ulke(rs.getString("firma_ulke"));
                tmp.setSilahlar(this.getSilahlarDAO().find(rs.getLong("silah_id")));
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
            PreparedStatement pst = getConn().prepareStatement("select count(firma_id) as firma_count from firma ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("firma_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
