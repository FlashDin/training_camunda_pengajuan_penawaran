package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Produk;
import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.pojo.TaskVariable;
import co.id.javan.pengajuanproduk.services.CamundaProcessService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task/produk")
public class ProdukController {

    @Autowired
    private CamundaProcessService camundaProcessService;
    @Inject
    private RuntimeService runtimeService;

    @GetMapping(path = "/active")
    public List<Produk> getActiveTasks(@RequestParam("taskDefinitionKey") String taskDefinitionKey) {
        List<Task> tasks = camundaProcessService.getActiveTasks(TaskVariable.processDefinitionKey, taskDefinitionKey);
        List<Produk> result = new ArrayList<>();
        for (Task task : tasks) {
            Produk produk = new Produk();
            produk.setId(task.getId());
            produk.setInstanceId(task.getProcessInstanceId());
            String namaProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaProduk");
            String merkProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "merkProduk");
            String noProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "noProduk");
            double hargaProduk = (Double) runtimeService.getVariable(task.getProcessInstanceId(), "hargaProduk");
            String kuantitasProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "kuantitasProduk");
            Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
            produk.setNamaProduk(namaProduk);
            produk.setMerkProduk(merkProduk);
            produk.setNoProduk(noProduk);
            produk.setHargaProduk(hargaProduk);
            produk.setKuantitasProduk(kuantitasProduk);
            produk.setPenawaran(penawaran);
            result.add(produk);
        }
        return result;
    }

    @GetMapping(path = "/{processInstanceId}")
    public Produk getTask(@RequestParam("taskDefinitionKey") String taskDefinitionKey,
                               @PathVariable("processInstanceId") String processInstanceId) {
        Task task = camundaProcessService.getTask(TaskVariable.processDefinitionKey, taskDefinitionKey, processInstanceId);
        Produk produk = new Produk();
        produk.setId(task.getId());
        produk.setInstanceId(task.getProcessInstanceId());
        String namaProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaProduk");
        String merkProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "merkProduk");
        String noProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "noProduk");
        double hargaProduk = (Double) runtimeService.getVariable(task.getProcessInstanceId(), "hargaProduk");
        String kuantitasProduk = (String) runtimeService.getVariable(task.getProcessInstanceId(), "kuantitasProduk");
        Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
        produk.setNamaProduk(namaProduk);
        produk.setMerkProduk(merkProduk);
        produk.setNoProduk(noProduk);
        produk.setHargaProduk(hargaProduk);
        produk.setKuantitasProduk(kuantitasProduk);
        produk.setPenawaran(penawaran);
        return produk;
    }

}
