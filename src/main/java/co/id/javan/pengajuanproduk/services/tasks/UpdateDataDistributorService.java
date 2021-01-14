package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Distributor;
import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.DistributorRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDataDistributorService implements JavaDelegate {

    @Autowired
    private DistributorRepository distributorRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Distributor");
        Distributor distributor = new Distributor();
        distributor.setNamaDistributor((String) delegateExecution.getVariable("namaDistributor"));
        distributor.setNpwpDistributor((String) delegateExecution.getVariable("npwpDistributor"));
        distributor.setEmailDistributor((String) delegateExecution.getVariable("emailDistributor"));
        distributor.setPenawaran((Penawaran) delegateExecution.getVariable("penawaran"));
        distributor.setInstanceId(delegateExecution.getProcessInstanceId());
        distributorRepository.save(distributor);
    }
}
