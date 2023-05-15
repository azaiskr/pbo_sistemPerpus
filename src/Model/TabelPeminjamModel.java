/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nuraz
 */
public class TabelPeminjamModel extends AbstractTableModel{

    List<Peminjam> listPeminjam;
    
    public TabelPeminjamModel(List<Peminjam> listPeminjam){
       this.listPeminjam = listPeminjam; 
    }
    
    @Override
    public int getRowCount() {
        return this.listPeminjam.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama Mahasiswa";
            case 2:
                return "Program Studi";
            case 3:
                return "Jurusan";
            case 4:
                return "Tahun Angkatan";
            case 5:
                return "No HP";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listPeminjam.get(rowIndex).getId_peminjam();
            case 1:
                return listPeminjam.get(rowIndex).getNama_peminjam();
            case 2:
                return listPeminjam.get(rowIndex).getProdi();
            case 3:
                return listPeminjam.get(rowIndex).getJurusan();
            case 4:
                return listPeminjam.get(rowIndex).getAngkatan();
            case 5:
                return listPeminjam.get(rowIndex).getNomor_Hp();
            default:
                return null;
        }
    }
}
