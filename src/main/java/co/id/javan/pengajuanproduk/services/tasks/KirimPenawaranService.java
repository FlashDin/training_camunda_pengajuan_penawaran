package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.PenawaranRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KirimPenawaranService implements JavaDelegate {

    @Autowired
    private PenawaranRepository penawaranRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Kirim Penawaran");
        Optional<Penawaran> optionalPenawaran = penawaranRepository.findById((Long) delegateExecution.getVariable("idPenawaran"));
        if (optionalPenawaran.isPresent()) {
            Penawaran penawaran = optionalPenawaran.get();
            penawaran.setStatusPenawaran("Menunggu Persetujuan");
            penawaranRepository.save(penawaran);
        }
    }
}
