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
    
    FormBuku frmBuku;
    IDAOBuku iBuku;
    List<Buku> listBuku;
}
