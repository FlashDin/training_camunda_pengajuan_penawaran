package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.DokumenRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDataDokumenService implements JavaDelegate {

    @Autowired
    private DokumenRepository dokumenRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Dokumen");
//        Dokumen dokumen = new Dokumen();
//        dokumen.setPathDokumen((String) delegateExecution.getVariable("pathDokumen"));
//        dokumen.setPenawaran((Penawaran) delegateExecution.getVariable("penawaran"));
//        dokumen.setInstanceId(delegateExecution.getProcessInstanceId());
//        dokumenRepository.save(dokumen);
    }
}
