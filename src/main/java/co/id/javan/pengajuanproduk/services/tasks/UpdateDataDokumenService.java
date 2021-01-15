package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.repositories.DokumenRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UpdateDataDokumenService implements JavaDelegate {

    @Autowired
    private DokumenRepository dokumenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Dokumen");
        List<LinkedHashMap<String, Object>> ls = (List<LinkedHashMap<String, Object>>) delegateExecution.getVariable("produks");
        List<Dokumen> dokumens = modelMapper.map(ls, new TypeToken<List<Dokumen>>() {
        }.getType());
        dokumens.forEach(dokumen -> dokumen.setInstanceId(delegateExecution.getProcessInstanceId()));
        dokumenRepository.saveAll(dokumens);
    }
}
