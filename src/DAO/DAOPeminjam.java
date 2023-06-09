/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAOInterface.IDAOPeminjam;
import Helper.KoneksiDB;
import Model.Peminjam;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nuraz
 */
public class DAOPeminjam implements IDAOPeminjam{
    
    Connection con;
    //SQL Query 
    String strRead = "SELECT * FROM `tbl_peminjam`;"; 
    String strInsert = "INSERT INTO `tbl_peminjam` (`id_peminjam`, `nama_peminjam`, `prodi`, `jurusan`, `angkatan`, `nomor_Hp`) VALUES (?, ?, ?, ?, ?, ?);";
    String strUpdate = "UPDATE `tbl_peminjam` SET `nama_peminjam`=?, `prodi`=?, `jurusan`=?, `angkatan`=?, `nomor_Hp`=? WHERE `id_peminjam`=?;";
    String strDelete = "DELETE FROM `tbl_peminjam` where `id_peminjam`=?;";
    String strCarinama = "SELECT * FROM `tbl_peminjam` where `nama_peminjam` like?;";
    
    public DAOPeminjam(){
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public List<Peminjam> getAll() {
        List<Peminjam> listPeminjam = null;
        try
        {
            listPeminjam = new ArrayList<Peminjam>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(strRead);
            while(rs.next())
            {
                Peminjam mhs = new Peminjam();
                mhs.setId_peminjam(rs.getInt("id_peminjam"));
                mhs.setNama_peminjam(rs.getString("nama_peminjam"));
                mhs.setProdi(rs.getString("prodi"));
                mhs.setJurusan(rs.getString("jurusan"));
                mhs.setAngkatan(rs.getInt("angkatan"));
                mhs.setNomor_Hp(rs.getString("nomor_Hp"));
                listPeminjam.add(mhs);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: " + e);
        }
        return listPeminjam;
    }

    @Override
    public void insert(Peminjam b) {
        PreparedStatement statement =null;
        try{
            statement = con.prepareStatement(strInsert);
            statement.setInt(1, b.getId_peminjam());
            statement.setString(2, b.getNama_peminjam());
            statement.setString(3, b.getProdi());
            statement.setString(4, b.getJurusan());
            statement.setInt(5, b.getAngkatan());
            statement.setString(6, b.getNomor_Hp());
            statement.execute();
        }
        catch(SQLException e) {
            System.out.println("Gagal Menambah Data!");
        }
        finally {
            try{
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menambah Data!");
            }
        }
    }

    @Override
    public void update(Peminjam b) {
        PreparedStatement statement =null;
        try{
            statement = con.prepareStatement(strUpdate);
            statement.setString(1, b.getNama_peminjam());
            statement.setString(2, b.getProdi());
            statement.setString(3, b.getJurusan());
            statement.setInt(4, b.getAngkatan());
            statement.setString(5, b.getNomor_Hp());
            statement.setInt(6, b.getId_peminjam());
            statement.execute();
        }
        catch(SQLException e) {
            System.out.println("Gagal Update data!");
        }
        finally {
            try{
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update Data!");
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement =null;
        try{
            statement = con.prepareStatement(strDelete);
            statement.setInt(1, id);
            statement.execute();
        }
        catch(SQLException e) {
            System.out.println("Gagal Menghapus Data!");
        }
        finally {
            try{
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Menghapus Data!");
            }
        }
    }

    @Override
    public List<Peminjam> getCariNama(String nama_peminjam) {
        List<Peminjam> listPeminjam = null;
        try {
            listPeminjam = new ArrayList<Peminjam>();
            PreparedStatement st = con.prepareStatement(strCarinama);
            st.setString(1,"%" + nama_peminjam + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Peminjam b = new Peminjam();
                b.setId_peminjam(rs.getInt("id_peminjam"));
                b.setNama_peminjam(rs.getString("nama_peminjam"));
                b.setProdi(rs.getString("prodi"));
                b.setJurusan(rs.getString("jurusan"));
                b.setAngkatan(rs.getInt("angkatan"));
                b.setNomor_Hp(rs.getString("nomor_Hp"));
                listPeminjam.add(b);
            }
        }
        catch (SQLException ex){
            Logger.getLogger(DAOPeminjam.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        return listPeminjam;
    }
}
