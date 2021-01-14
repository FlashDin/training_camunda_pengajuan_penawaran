package co.id.javan.pengajuanproduk.services.tasks;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.repositories.ProdukRepository;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDataProdukService implements JavaDelegate {

    @Autowired
    private ProdukRepository produkRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Update Produk");
        Produk produk = new Produk();
        produk.setNamaProduk((String) delegateExecution.getVariable("namaProduk"));
        produk.setMerkProduk((String) delegateExecution.getVariable("merkProduk"));
        produk.setNoProduk((String) delegateExecution.getVariable("noProduk"));
        produk.setHargaProduk((Double) delegateExecution.getVariable("hargaProduk"));
        produk.setKuantitasProduk((String) delegateExecution.getVariable("kuantitasProduk"));
        produk.setPenawaran((Penawaran) delegateExecution.getVariable("penawaran"));
        produk.setInstanceId((String) delegateExecution.getVariable("instanceId"));
        produkRepository.save(produk);
    }
}
