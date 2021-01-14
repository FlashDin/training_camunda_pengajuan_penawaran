package co.id.javan.pengajuanproduk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Dokumen extends TaskVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private long idDokumen;
    @Column(columnDefinition = "varchar(50)")
    private String pathDokumen;
    @ManyToOne(targetEntity = Penawaran.class)
    @JoinColumn(name = "id_penawaran", referencedColumnName = "idPenawaran")
    private Penawaran penawaran;


}
