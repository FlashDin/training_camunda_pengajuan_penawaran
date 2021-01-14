package co.id.javan.pengajuanproduk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Transient;

@Getter
@Setter
public class TaskVariable {

    @Transient
    protected String id;
    @Column(columnDefinition = "varchar(50)")
    protected String instanceId;
    @Transient
    public static final String processDefinitionKey = "prc_pengajuan_penawaran";

}
