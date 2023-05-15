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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    Connection con;
    // SQL Query
    String strRead = "select * from tbl_buku";
}
