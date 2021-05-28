/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.uye;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onur
 */
public class uyeDAO extends DAO {

    public List<uye> hepsiniOku(int page, int pageSize) {
        List<uye> ulist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from uye order by uye_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                uye tmp = new uye();
                tmp.setUye_id(rs.getLong("uye_id"));
                tmp.setAdı(rs.getString("adi"));
                tmp.setSoyadı(rs.getString("soyad"));
                tmp.setEmail(rs.getString("email"));
                tmp.setSifre(rs.getString("sifre"));

                ulist.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ulist;
    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(uye_id) as uye_count from uye");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("uye_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public void ekle(uye uye) {
        String query = "insert into uye(uye_id,adi,soyad,email,sifre,admin) values(default,?,?,?,?,false)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, uye.getAdı());
            pst.setString(2, uye.getSoyadı());
            pst.setString(3, uye.getEmail());
            pst.setString(4, uye.getSifre());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(uye uye) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from uye where uye_id=?");
            pst.setLong(1, uye.getUye_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(uye uye) {
        String query = "update uye set adi=?,soyad=?,email=?,sifre=? where uye_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, uye.getAdı());
            pst.setString(2, uye.getSoyadı());
            pst.setString(3, uye.getEmail());
            pst.setString(4, uye.getSifre());
            pst.setLong(5, uye.getUye_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public uye girisYap(String email, String sifre) {
        uye tmp = null;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from uye where email = ? and sifre = ?");
            pst.setString(1, email);
            pst.setString(2, sifre);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                tmp = new uye();
                tmp.setUye_id(rs.getLong("uye_id"));
                tmp.setAdı(rs.getString("adi"));
                tmp.setSoyadı(rs.getString("soyad"));
                tmp.setEmail(rs.getString("email"));
                tmp.setSifre(rs.getString("sifre"));
                tmp.setAdmin(rs.getBoolean("admin"));

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }
}
