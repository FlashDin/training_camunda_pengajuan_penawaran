package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.PenawaranRepository;
import co.id.javan.pengajuanproduk.utils.MailSender;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PenawaranDiterimaService implements JavaDelegate {

    @Autowired
    private PenawaranRepository penawaranRepository;
    @Autowired
    private MailSender mailSender;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Penawaran diterima");
        Optional<Penawaran> optionalPenawaran = penawaranRepository.findById((Long) delegateExecution.getVariable("idPenawaran"));
        if (optionalPenawaran.isPresent()) {
            Penawaran penawaran = optionalPenawaran.get();
            penawaran.setStatusPenawaran("Penawaran Diterima");
            penawaranRepository.save(penawaran);
            mailSender.sendmail((String) delegateExecution.getVariable("emailPenawaran"), "Penawaran diterima", "Selamat", "Penawaran anda diterima");
        }
    }
}
