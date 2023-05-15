/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPeminjam;
import DAOInterface.IDAOPeminjam;
import View.FormPeminjam;
import java.util.List;
import Model.Peminjam;
import Model.TabelPeminjamModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nuraz
 */
public class PeminjamController {
    FormPeminjam frame;
    IDAOPeminjam implPeminjam;
    List<Peminjam> listPeminjam;
    
    public PeminjamController(FormPeminjam frame){
        this.frame = frame;
        implPeminjam = new DAOPeminjam();
        listPeminjam = implPeminjam.getAll();
    }
    
    //fill table
    public void isiTabel(){
        listPeminjam = implPeminjam.getAll();
        TabelPeminjamModel tmb = new TabelPeminjamModel(listPeminjam);
        frame.getTabelData().setModel(tmb);
    }
    
    //Reset Form
    public void reset(){
        frame.getNumId().setText("");
        frame.getTxtNama().setText("");
        frame.getTxtProdi().setText("");
        frame.getTxtJurusan().setText("");
        frame.getNumAngkatan().setText("");
        frame.getTxtNoHP().setText("");
    }
    
    //View searched data
    public void isiField(int row){
        frame.getNumId().setText(listPeminjam.get(row).getId_peminjam().toString());
        frame.getTxtNama().setText(listPeminjam.get(row).getNama_peminjam());
        frame.getTxtProdi().setText(listPeminjam.get(row).getProdi());
        frame.getTxtJurusan().setText(listPeminjam.get(row).getJurusan());
        frame.getNumAngkatan().setText(listPeminjam.get(row).getAngkatan().toString());
        frame.getTxtNoHP().setText(listPeminjam.get(row).getNomor_Hp());
    }
    
    //insert data
    public void insert(){
        if(!frame.getNumId().getText().trim().isEmpty()&!frame.getTxtNama().getText().trim().isEmpty()){
            Peminjam mhs = new Peminjam();
            mhs.setId_peminjam(Integer.valueOf(frame.getNumId().getText()));
            mhs.setNama_peminjam(frame.getTxtNama().getText());
            mhs.setProdi(frame.getTxtProdi().getText());
            mhs.setJurusan(frame.getTxtJurusan().getText());
            mhs.setAngkatan(Integer.valueOf(frame.getNumAngkatan().getText()));
            mhs.setNomor_Hp(frame.getTxtNoHP().getText());
            implPeminjam.insert(mhs);
            JOptionPane.showMessageDialog(null," Data Berhasil Disimpan");
        } else {
            JOptionPane.showMessageDialog(frame, "Data Tidak Boleh Kosong");
        }
    }
}
