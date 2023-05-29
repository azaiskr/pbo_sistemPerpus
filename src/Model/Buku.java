/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ROG
 */
public class Buku {

    /**
     * @return the id_buku
     */
    public Integer getId_buku() {
        return id_buku;
    }

    /**
     * @param id_buku the id_buku to set
     */
    public void setId_buku(Integer id_buku) {
        this.id_buku = id_buku;
    }

    /**
     * @return the judul_buku
     */
    public String getJudul_buku() {
        return judul_buku;
    }

    /**
     * @param judul_buku the judul_buku to set
     */
    public void setJudul_buku(String judul_buku) {
        this.judul_buku = judul_buku;
    }

    /**
     * @return the katalog_jenis
     */
    public String getKatalog_jenis() {
        return katalog_jenis;
    }

    /**
     * @param katalog_jenis the katalog_jenis to set
     */
    public void setKatalog_jenis(String katalog_jenis) {
        this.katalog_jenis = katalog_jenis;
    }

    /**
     * @return the penulis
     */
    public String getPenulis() {
        return penulis;
    }

    /**
     * @param penulis the penulis to set
     */
    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the tahun_terbit
     */
    public Integer getTahun_terbit() {
        return tahun_terbit;
    }

    /**
     * @param tahun_terbit the tahun_terbit to set
     */
    public void setTahun_terbit(Integer tahun_terbit) {
        this.tahun_terbit = tahun_terbit;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the jumlah_tersedia
     */
    public Integer getJumlah_tersedia() {
        return jumlah_tersedia;
    }

    /**
     * @param jumlah_tersedia the jumlah_tersedia to set
     */
    public void setJumlah_tersedia(Integer jumlah_tersedia) {
        this.jumlah_tersedia = jumlah_tersedia;
    }
    
    /**
     * @return the isbn
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }
    private Integer id_buku;
    private String judul_buku;
    private String katalog_jenis;
    private String penulis;
    private String penerbit;
    private Integer tahun_terbit;
    private String status;
    private Integer jumlah_tersedia;
    private String isbn;
}
