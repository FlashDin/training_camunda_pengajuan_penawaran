package co.id.javan.pengajuanproduk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Produk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private long idProduk;
    @Column(columnDefinition = "varchar(50)")
    private String namaProduk;
    @Column(columnDefinition = "varchar(50)")
    private String merkProduk;
    @Column(columnDefinition = "varchar(50)")
    private String noProduk;
    @Column(columnDefinition = "varchar(50)")
    private double hargaProduk;
    @Column(columnDefinition = "varchar(50)")
    private String kuantitasProduk;

}
