package co.id.javan.pengajuanproduk.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;

@Getter
@Setter
public class TaskVariable {

    @Transient
    protected String id;
    @Transient
    public static final String processDefinitionKey = "prc_pengajuan_penawaran";

}
