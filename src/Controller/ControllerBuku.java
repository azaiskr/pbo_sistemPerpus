/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOBuku;
import DAOInterface.IDAOBuku;
import Model.Buku;
import Model.TabelModelBuku;
import View.FormBuku;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ROG
 */
public class ControllerBuku {
    
    
    public ControllerBuku(FormBuku frmBuku)
    {
        this.frmBuku = frmBuku;
        iBuku = new DAOBuku();
    }
    
    public void isiTable()
    {
        listBuku = iBuku.getAll();
        TabelModelBuku tabelBuku = new TabelModelBuku(listBuku);
        frmBuku.getTabelData().setModel(tabelBuku);
    }
    
    public void insert()
    {
        Buku b = new Buku();
        b.setId_buku(Integer.parseInt(frmBuku.gettxtID().getText()));
        b.setJudul_buku(frmBuku.gettxtJudul().getText());
        b.setKatalog_jenis(frmBuku.gettxtJenis().getText());
        b.setPenulis(frmBuku.gettxtPenulis().getText());
        b.setPenerbit(frmBuku.gettxtPenerbit().getText());
        b.setTahun_terbit(Integer.parseInt(frmBuku.gettxtTahun().getText()));
        b.setStatus(frmBuku.getStatus().getSelectedItem().toString());
        b.setJumlah_tersedia(Integer.parseInt(frmBuku.gettxtJumlah().getText()));
        boolean res = iBuku.insert(b);
        if(res)
        {
            JOptionPane.showMessageDialog(null, "Input Berhasil");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Input Gagal / Data Duplikat");
        }
    }
    
    public void reset()
    {
        if(!frmBuku.gettxtID().isEnabled())
        {
            frmBuku.gettxtID().setEnabled(true);
        }
        frmBuku.gettxtID().setText("");
        frmBuku.gettxtJudul().setText("");
        frmBuku.gettxtJenis().setText("");
        frmBuku.gettxtPenulis().setText("");
        frmBuku.gettxtPenerbit().setText("");
        frmBuku.gettxtTahun().setText("");
        frmBuku.getStatus().setSelectedItem("L");
        frmBuku.gettxtJumlah().setText("");
    }
    
    public void isiField(int row)
    {
        frmBuku.gettxtID().setEnabled(false);
        frmBuku.gettxtID().setText(listBuku.get(row).getId_buku().toString());
        frmBuku.gettxtJudul().setText(listBuku.get(row).getJudul_buku());
        frmBuku.gettxtJenis().setText(listBuku.get(row).getKatalog_jenis());
        frmBuku.gettxtPenulis().setText(listBuku.get(row).getPenulis());
        frmBuku.gettxtPenerbit().setText(listBuku.get(row).getPenerbit());
        frmBuku.gettxtTahun().setText(listBuku.get(row).getTahun_terbit().toString());
        frmBuku.getStatus().setSelectedItem(listBuku.get(row).getStatus());
        frmBuku.gettxtJumlah().setText(listBuku.get(row).getJumlah_tersedia().toString());
    }
    
    public void update()
    {
        Buku b = new Buku();
        b.setJudul_buku(frmBuku.gettxtJudul().getText());
        b.setKatalog_jenis(frmBuku.gettxtJenis().getText());
        b.setPenulis(frmBuku.gettxtPenulis().getText());
        b.setPenerbit(frmBuku.gettxtPenerbit().getText());
        b.setTahun_terbit(Integer.parseInt(frmBuku.gettxtTahun().getText()));
        b.setStatus(frmBuku.getStatus().getSelectedItem().toString());
        b.setJumlah_tersedia(Integer.parseInt(frmBuku.gettxtJumlah().getText()));
        b.setId_buku(Integer.parseInt(frmBuku.gettxtID().getText()));
        iBuku.update(b);
        JOptionPane.showMessageDialog(null, "Update Berhasil");
    }
    
    public void delete()
    {
        Buku b = new Buku();
        iBuku.delete(Integer.parseInt(frmBuku.gettxtID().getText()));
        JOptionPane.showMessageDialog(null, "Delete Berhasil");
    }
    
    public void search()
    {
        listBuku = iBuku.getAllByName(frmBuku.gettxtCariBuku().getText());
        TabelModelBuku tabelBuku = new TabelModelBuku(listBuku);
        frmBuku.getTabelData().setModel(tabelBuku);
    }
    
    FormBuku frmBuku;
    IDAOBuku iBuku;
    List<Buku> listBuku;
}
