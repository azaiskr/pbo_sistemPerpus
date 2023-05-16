/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author nuraz
 */
public class Peminjam {

    /** 
     * @return the id_peminjam
     */
    public Integer getId_peminjam() {
        return id_peminjam;
    }

    /**
     * @param id_peminjam the id_peminjam to set
     */
    public void setId_peminjam(Integer id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    /**
     * @return the nama_peminjam
     */
    public String getNama_peminjam() {
        return nama_peminjam;
    }

    /**
     * @param nama_peminjam the nama_peminjam to set
     */
    public void setNama_peminjam(String nama_peminjam) {
        this.nama_peminjam = nama_peminjam;
    }

    /**
     * @return the prodi
     */
    public String getProdi() {
        return prodi;
    }

    /**
     * @param prodi the prodi to set
     */
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    /**
     * @return the jurusan
     */
    public String getJurusan() {
        return jurusan;
    }

    /**
     * @param jurusan the jurusan to set
     */
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    /**
     * @return the angkatan
     */
    public Integer getAngkatan() {
        return angkatan;
    }

    /**
     * @param angkatan the angkatan to set
     */
    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }

    /**
     * @return the nomor_Hp
     */
    public String getNomor_Hp() {
        return nomor_Hp;
    }

    /**
     * @param nomor_Hp the nomor_Hp to set
     */
    public void setNomor_Hp(String nomor_Hp) {
        this.nomor_Hp = nomor_Hp;
    }
    private Integer id_peminjam;
    private String nama_peminjam;
    private String prodi;
    private String jurusan;
    private Integer angkatan;
    private String nomor_Hp;
}
