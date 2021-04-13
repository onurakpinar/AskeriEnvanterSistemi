/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Silahlar;
import entity.Tur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Onur
 */
public class SilahlarDAO extends DAO {

    private DocumentDAO documentDAO;
    private TurDAO turDAO;

    public void ekle(Silahlar silahlar) {
        String query = "insert into silahlar (silah_id,silah_isim,uretim_yili,document_id,turr) values(default,?,?,?,?)";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, silahlar.getSilah_isim());
            pst.setInt(2, silahlar.getUretim_yili());
            pst.setLong(3, silahlar.getDocument().getId());
            pst.setString(4, silahlar.getTurr());
            pst.executeUpdate();

            /* composite için yaptık ...*/
      

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sil(Silahlar silahlar) {
        try {
            PreparedStatement pst = getConn().prepareStatement("delete from silahlar where silah_id=?");
            pst.setLong(1, silahlar.getSilah_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void guncelle(Silahlar silahlar) {
        String query = "update silahlar set silah_isim=?,uretim_yili=?,document_id=?,turr=? where silah_id=?";

        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            pst.setString(1, silahlar.getSilah_isim());
            pst.setInt(2, silahlar.getUretim_yili());
            pst.setLong(3, silahlar.getDocument().getId());
            pst.setString(4, silahlar.getTurr());
            pst.setLong(5, silahlar.getSilah_id());
            pst.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Silahlar> hepsiniOku(int page, int pageSize) {
        List<Silahlar> yList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            PreparedStatement pst = getConn().prepareStatement("select * from silahlar order by silah_id asc OFFSET " + start + " LIMIT " + pageSize);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Silahlar tmp = new Silahlar();
                tmp.setSilah_id(rs.getLong("silah_id"));
                tmp.setSilah_isim(rs.getString("silah_isim"));
                tmp.setUretim_yili(rs.getInt("uretim_yili"));
                tmp.setDocument(this.getDocumentDAO().find(rs.getLong("document_id")));
                tmp.setTurr(rs.getString("turr"));
                yList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return yList;

    }

    public int count() {
        int count = 0;

        try {
            PreparedStatement pst = getConn().prepareStatement("select count(silah_id) as silahlar_count from silahlar");
            ResultSet rs = pst.executeQuery();
            rs.next();
            count = rs.getInt("silahlar_count");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public Silahlar find(Long id) {
        Silahlar si = null;
        String query = ("select * from silahlar where silah_id=" + id);
        try {
            PreparedStatement pst = getConn().prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            rs.next();

            si = new Silahlar();
            si.setSilah_id(rs.getLong("silah_id"));
            si.setSilah_isim(rs.getString("silah_isim"));
            si.setUretim_yili(rs.getInt("uretim_yili"));
            si.setTurr(rs.getString("turr"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return si;

    }

    public List<Silahlar> hepsiniOku() {
        List<Silahlar> sList = new ArrayList<>();

        try {
            PreparedStatement pst = getConn().prepareStatement("select * from silahlar order by silah_id asc");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Silahlar tmp = new Silahlar();
                tmp.setSilah_id(rs.getLong("silah_id"));
                tmp.setSilah_isim(rs.getString("silah_isim"));
                tmp.setUretim_yili(rs.getInt("uretim_yili"));
                tmp.setDocument(this.getDocumentDAO().find(rs.getLong("document_id")));
                tmp.setTurr(rs.getString("turr"));
                sList.add(tmp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sList;
    }

    public DocumentDAO getDocumentDAO() {
        if (this.documentDAO == null) {
            this.documentDAO = new DocumentDAO();
        }
        return documentDAO;
    }

    public void setDocumentDAO(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public TurDAO getTurDAO() {
        if (this.turDAO == null) {
            this.turDAO = new TurDAO();
        }
        return turDAO;
    }

    public void setTurDAO(TurDAO turDAO) {
        this.turDAO = turDAO;
    }

}
