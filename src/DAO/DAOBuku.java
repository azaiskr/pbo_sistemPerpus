/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOBuku;
import Helper.KoneksiDB;
import Model.Buku;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ROG
 */
public class DAOBuku implements IDAOBuku{

    public DAOBuku()
    {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<Buku> getAll() {
        List<Buku> listBuku = null;
        try
        {
            listBuku = new ArrayList<Buku>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Buku buku = new Buku();
                buku.setId_buku(rs.getInt("id_buku"));
                buku.setJudul_buku(rs.getString("judul_buku"));
                buku.setKatalog_jenis(rs.getString("katalog_jenis"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahun_terbit(rs.getInt("tahun_terbit"));
                buku.setStatus(rs.getString("status"));
                buku.setJumlah_tersedia(rs.getInt("jumlah_tersedia"));
                listBuku.add(buku);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return listBuku;
    }
    
    @Override
    public boolean insert(Buku b) {
        boolean result=true;
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getId_buku());
            statement.setString(2, b.getJudul_buku());
            statement.setString(3, b.getKatalog_jenis());
            statement.setString(4, b.getPenulis());
            statement.setString(5, b.getPenerbit());
            statement.setInt(6, b.getTahun_terbit());
            statement.setString(7, b.getStatus());
            statement.setInt(8, b.getJumlah_tersedia());
            statement.execute();
        }
        catch(SQLException e)
        {
            System.out.println("Gagal Input!");
            result=false;
        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Input!");
                result=false;
            }
        }
        return result;
    }
    
    @Override
    public void update(Buku b) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getJudul_buku());
            statement.setString(2, b.getKatalog_jenis());
            statement.setString(3, b.getPenulis());
            statement.setString(4, b.getPenerbit());
            statement.setInt(5, b.getTahun_terbit());
            statement.setString(6, b.getStatus());
            statement.setInt(7, b.getJumlah_tersedia());
            statement.setInt(8, b.getId_buku());
            statement.execute();
        }
        catch(SQLException e)
        {
            System.out.println("Gagal Update!");
        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update!");
            }
        }
    }
    
    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try
        {
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.execute();
        }
        catch(SQLException e)
        {
            System.out.println("Gagal Delete!");
        }
        finally
        {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Delete!");
            }
        }
    }
    
    @Override
    public List<Buku> getAllByName(String judul_buku) {
        List<Buku> listBuku = null;
        try
        {
            listBuku = new ArrayList<Buku>();
            PreparedStatement st = con.prepareStatement(strSearch);
            st.setString(1, "%"+judul_buku+"%");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                Buku buku = new Buku();
                buku.setId_buku(rs.getInt("id_buku"));
                buku.setJudul_buku(rs.getString("judul_buku"));
                buku.setKatalog_jenis(rs.getString("katalog_jenis"));
                buku.setPenulis(rs.getString("penulis"));
                buku.setPenerbit(rs.getString("penerbit"));
                buku.setTahun_terbit(rs.getInt("tahun_terbit"));
                buku.setStatus(rs.getString("status"));
                buku.setJumlah_tersedia(rs.getInt("jumlah_tersedia"));
                listBuku.add(buku);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: "+e);
        }
        return listBuku;
    }
    
    Connection con;
    // SQL Query
    String strRead = "select * from tbl_buku order by id;";
    String strInsert = "insert into tbl_buku (id_buku,judul_buku,katalog_jenis,penulis,penerbit,tahun_terbit,status,jumlah_tersedia) values (?,?,?,?,?,?,?,?);";
    String strUpdate = "update tbl_buku set judul_buku=?, katalog_jenis=?, penulis=?, penerbit=?, tahun_terbit=?, status=?, jumlah_tersedia=? where id_buku=?";
    String strDelete = "delete from tbl_buku where id=?";
    String strSearch = "select * from tbl_buku where judul_buku like ?;";
}
