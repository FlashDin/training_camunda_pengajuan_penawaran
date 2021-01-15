package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Distributor;
import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.repositories.DistributorRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UpdateDataDistributorService implements JavaDelegate {

    @Autowired
    private DistributorRepository distributorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Distributor");
        List<LinkedHashMap<String, Object>> ls = (List<LinkedHashMap<String, Object>>) delegateExecution.getVariable("distributors");
        List<Distributor> distributors = modelMapper.map(ls, new TypeToken<List<Distributor>>() {
        }.getType());
        distributors.forEach(distributor -> distributor.setInstanceId(delegateExecution.getProcessInstanceId()));
        distributorRepository.saveAll(distributors);
    }
}
