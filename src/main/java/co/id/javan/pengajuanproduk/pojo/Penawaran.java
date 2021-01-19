package co.id.javan.pengajuanproduk.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Penawaran extends TaskVariable {

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
    @Column(columnDefinition = "varchar(20)")
    private String statusPenawaran;
    @Column(columnDefinition = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tglPengajuan;

    @Column(columnDefinition = "varchar(50)")
    protected String instanceId;

    @OneToMany(mappedBy = "penawaran", fetch = FetchType.LAZY)
    private List<Distributor> distributors;
    @OneToMany(mappedBy = "penawaran", fetch = FetchType.LAZY)
    private List<Dokumen> dokumens;
    @OneToMany(mappedBy = "penawaran", fetch = FetchType.LAZY)
    private List<Produk> produks;

}
