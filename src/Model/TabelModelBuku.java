/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ROG
 */
public class TabelModelBuku extends AbstractTableModel{

    public TabelModelBuku(List<Buku> listBuku)
    {
       this.listBuku = listBuku; 
    }
    @Override
    public int getRowCount() {
        return this.listBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Judul Buku";
            case 2:
                return "Jenis";
            case 3:
                return "Penulis";
            case 4:
                return "Penerbit";
            case 5:
                return "Tahun Terbit";
            case 6:
                return "Status";
            case 7:
                return "Jumlah Tersedia";
            case 8:
                return "ISBN";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listBuku.get(rowIndex).getId_buku();
            case 1:
                return listBuku.get(rowIndex).getJudul_buku();
            case 2:
                return listBuku.get(rowIndex).getKatalog_jenis();
            case 3:
                return listBuku.get(rowIndex).getPenulis();
            case 4:
                return listBuku.get(rowIndex).getPenerbit();
            case 5:
                return listBuku.get(rowIndex).getTahun_terbit();
            case 6:
                return listBuku.get(rowIndex).getStatus();
            case 7:
                return listBuku.get(rowIndex).getJumlah_tersedia();
            case 8:
                return listBuku.get(rowIndex).getISBN();
            default:
                return null;
        }
    }
    
    List<Buku> listBuku;
}
