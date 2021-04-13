/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Musteri;
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
public class MusteriDAO extends DAO {

    private SilahlarDAO silahlarDAO;

    public SilahlarDAO getSilahlarDAO() {
        if (silahlarDAO == null) {
            silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

    public void ekle(Musteri musteri) {
        try {
            PreparedStatement pst = getConn().prepareStatement("insert into musteri(musteri_id,musteri_isim,musteri_ulke,silah_id,adet) values (default,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, musteri.getMusteri_isim());
            pst.setString(2, musteri.getMusteri_ulke());
            pst.setLong(3, musteri.getSilahlar().getSilah_id());
            pst.setInt(4, musteri.getAdet());

            pst.executeUpdate();

            ResultSet gk = pst.getGeneratedKeys();
            Long musteri_id = null;
            if (gk.next()) {
                musteri_id = gk.getLong(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sil(Musteri musteri) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from musteri where musteri_id=?");
            pst.setLong(1, musteri.getMusteri_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Musteri musteri) {
        try {
            PreparedStatement pst = getConn().prepareStatement("update musteri set musteri_isim=?,musteri_ulke=?,silah_id=?,adet=? where musteri_id=?");
            pst.setString(1, musteri.getMusteri_isim());
            pst.setString(2, musteri.getMusteri_ulke());
            pst.setLong(3, musteri.getSilahlar().getSilah_id());
            pst.setInt(4, musteri.getAdet());
            pst.setLong(5, musteri.getMusteri_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Musteri> hepsiniOku(int page, int pageSize) {
        List<Musteri> flist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from musteri order by musteri_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Musteri tmp = new Musteri();
                tmp.setMusteri_id(rs.getLong("musteri_id"));
                tmp.setMusteri_isim(rs.getString("musteri_isim"));
                tmp.setMusteri_ulke(rs.getString("musteri_ulke"));
                tmp.setSilahlar(this.getSilahlarDAO().find(rs.getLong("silah_id")));
                tmp.setAdet(rs.getInt("adet"));
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
            PreparedStatement pst = getConn().prepareStatement("select count(musteri_id) as musteri_count from musteri ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("musteri_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
