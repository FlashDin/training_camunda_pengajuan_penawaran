package co.id.javan.pengajuanproduk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Penawaran {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private long idPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String judulUsulanPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String namaKomoditasPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String namaPenyediaPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String emailPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String alamatPenawaran;
    @Column(columnDefinition = "varchar(50)")
    private String noTelpPenawaran;
    @Column(columnDefinition = "boolean")
    private boolean statusPenawaran;

}
