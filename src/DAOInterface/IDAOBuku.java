/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;

import Model.Buku;
import java.util.List;

/**
 *
 * @author ROG
 */
public interface IDAOBuku {
    //read data
    public List<Buku> getAll();
}
