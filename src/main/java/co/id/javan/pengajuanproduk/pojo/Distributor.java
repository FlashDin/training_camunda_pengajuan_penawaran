package co.id.javan.pengajuanproduk.pojo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
public class Distributor extends TaskVariable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private long idDistributor;
    @Column(columnDefinition = "varchar(50)")
    private String namaDistributor;
    @Column(columnDefinition = "varchar(50)")
    private String npwpDistributor;
    @Column(columnDefinition = "varchar(50)")
    private String emailDistributor;
    @JsonIgnore
    @ManyToOne(targetEntity = Penawaran.class)
    @JoinColumn(name = "id_penawaran", referencedColumnName = "idPenawaran")
    private Penawaran penawaran;

    @Column(columnDefinition = "varchar(50)")
    protected String instanceId;

}
