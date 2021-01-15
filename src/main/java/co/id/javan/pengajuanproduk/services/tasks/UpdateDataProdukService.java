package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.repositories.ProdukRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class UpdateDataProdukService implements JavaDelegate {

    @Autowired
    private ProdukRepository produkRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Produk");
        List<LinkedHashMap<String, Object>> ls = (List<LinkedHashMap<String, Object>>) delegateExecution.getVariable("produks");
        List<Produk> produks = modelMapper.map(ls, new TypeToken<List<Produk>>() {
        }.getType());
        produks.forEach(produk -> produk.setInstanceId(delegateExecution.getProcessInstanceId()));
        produkRepository.saveAll(produks);
    }
}
