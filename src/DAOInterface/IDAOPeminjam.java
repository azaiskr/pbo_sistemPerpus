/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Peminjam;
import java.util.List;

/**
 *
 * @author nuraz
 */
public interface IDAOPeminjam {
    public List<Peminjam> getAll(); //readData
    public void insert(Peminjam b); //
    public void update(Peminjam b); //update
    public void delete(int id); //erase
    public List<Peminjam> getCariNama(String nama);
}
