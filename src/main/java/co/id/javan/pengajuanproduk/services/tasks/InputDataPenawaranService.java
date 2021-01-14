package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.PenawaranRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class InputDataPenawaranService implements JavaDelegate {

    @Autowired
    private PenawaranRepository penawaranRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Input data penawaran");
        Penawaran penawaran = new Penawaran();
        penawaran.setJudulUsulanPenawaran((String) delegateExecution.getVariable("judulUsulanPenawaran"));
        penawaran.setNamaKomoditasPenawaran((String) delegateExecution.getVariable("namaKomoditasPenawaran"));
        penawaran.setNamaPenyediaPenawaran((String) delegateExecution.getVariable("namaPenyediaPenawaran"));
        penawaran.setEmailPenawaran((String) delegateExecution.getVariable("emailPenawaran"));
        penawaran.setAlamatPenawaran((String) delegateExecution.getVariable("alamatPenawaran"));
        penawaran.setNoTelpPenawaran((String) delegateExecution.getVariable("noTelpPenawaran"));
        penawaran.setStatusPenawaran((String) delegateExecution.getVariable("statusPenawaran"));
        penawaranRepository.save(penawaran);
    }
}
