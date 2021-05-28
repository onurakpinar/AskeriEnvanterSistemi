/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Envanter;
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
public class EnvanterDAO extends DAO {

    private SilahlarDAO silahlarDAO;

    public SilahlarDAO getSilahlarDAO() {
        if (silahlarDAO == null) {
            silahlarDAO = new SilahlarDAO();
        }
        return silahlarDAO;
    }

    public void ekle(Envanter envanter) {
        try {
            PreparedStatement pst = getConn().prepareStatement("insert into envanter(envanter_id,silah_id,envanter_isim,adet) values (default,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setLong(1, envanter.getSilahlar().getSilah_id());
            pst.setString(2, envanter.getEnvanter_isim());
            pst.setInt(3, envanter.getAdet());

            pst.executeUpdate();

            ResultSet gk = pst.getGeneratedKeys();
            Long envanter_id = null;
            if (gk.next()) {
                envanter_id = gk.getLong(1);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void sil(Envanter envanter) {

        try {
            PreparedStatement pst = getConn().prepareStatement("delete from envanter where envanter_id=?");
            pst.setLong(1, envanter.getEnvanter_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Envanter envanter) {
        try {
            PreparedStatement pst = getConn().prepareStatement("update envanter set silah_id=?,envanter_isim=?,adet=? where envanter_id=?");
            pst.setLong(1, envanter.getSilahlar().getSilah_id());
            pst.setString(2, envanter.getEnvanter_isim());
            pst.setInt(3, envanter.getAdet());
            pst.setLong(4, envanter.getEnvanter_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Envanter> hepsiniOku(int page, int pageSize) {
        List<Envanter> flist = new ArrayList<>();
        int start = (page - 1) * pageSize;

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from envanter order by envanter_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Envanter tmp = new Envanter();
                tmp.setEnvanter_id(rs.getLong("envanter_id"));
                tmp.setSilahlar(this.getSilahlarDAO().find(rs.getLong("silah_id")));
                tmp.setEnvanter_isim(rs.getString("envanter_isim"));
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
            PreparedStatement pst = getConn().prepareStatement("select count(envanter_id) as envanter_count from envanter ");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("envanter_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

}
