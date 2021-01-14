package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Penawaran;
import co.id.javan.pengajuanproduk.pojo.TaskVariable;
import co.id.javan.pengajuanproduk.repositories.PenawaranRepository;
import co.id.javan.pengajuanproduk.services.CamundaProcessService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/task/penawaran")
public class PenawaranController {

    @Autowired
    private CamundaProcessService camundaProcessService;
    @Inject
    private RuntimeService runtimeService;
    @Autowired
    private PenawaranRepository penawaranRepository;

    @GetMapping(path = "/active")
    public List<Penawaran> getActiveTasks(@RequestParam("taskDefinitionKey") String taskDefinitionKey) {
        List<Task> tasks = camundaProcessService.getActiveTasks(TaskVariable.processDefinitionKey, taskDefinitionKey);
        List<Penawaran> result = new ArrayList<>();
        for (Task task : tasks) {
            Penawaran penawaran = new Penawaran();
            penawaran.setId(task.getId());
            penawaran.setInstanceId(task.getProcessInstanceId());
            String judulUsulanPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "judulUsulanPenawaran");
            String namaKomoditasPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaKomoditasPenawaran");
            String namaPenyediaPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaPenyediaPenawaran");
            String emailPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "emailPenawaran");
            String alamatPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "alamatPenawaran");
            String noTelpPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "noTelpPenawaran");
            String statusPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "statusPenawaran");
            penawaran.setJudulUsulanPenawaran(judulUsulanPenawaran);
            penawaran.setNamaKomoditasPenawaran(namaKomoditasPenawaran);
            penawaran.setNamaPenyediaPenawaran(namaPenyediaPenawaran);
            penawaran.setEmailPenawaran(emailPenawaran);
            penawaran.setAlamatPenawaran(alamatPenawaran);
            penawaran.setNoTelpPenawaran(noTelpPenawaran);
            penawaran.setStatusPenawaran(statusPenawaran);
            result.add(penawaran);
        }
        return result;
    }

    @GetMapping(path = "/{processInstanceId}")
    public Penawaran getTask(@RequestParam("taskDefinitionKey") String taskDefinitionKey,
                             @PathVariable("processInstanceId") String processInstanceId) {
        Task task = camundaProcessService.getTask(TaskVariable.processDefinitionKey, taskDefinitionKey, processInstanceId);
        Penawaran penawaran = new Penawaran();
        penawaran.setId(task.getId());
        penawaran.setInstanceId(task.getProcessInstanceId());
        String judulUsulanPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "judulUsulanPenawaran");
        String namaKomoditasPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaKomoditasPenawaran");
        String namaPenyediaPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaPenyediaPenawaran");
        String emailPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "emailPenawaran");
        String alamatPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "alamatPenawaran");
        String noTelpPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "noTelpPenawaran");
        String statusPenawaran = (String) runtimeService.getVariable(task.getProcessInstanceId(), "statusPenawaran");
        penawaran.setJudulUsulanPenawaran(judulUsulanPenawaran);
        penawaran.setNamaKomoditasPenawaran(namaKomoditasPenawaran);
        penawaran.setNamaPenyediaPenawaran(namaPenyediaPenawaran);
        penawaran.setEmailPenawaran(emailPenawaran);
        penawaran.setAlamatPenawaran(alamatPenawaran);
        penawaran.setNoTelpPenawaran(noTelpPenawaran);
        penawaran.setStatusPenawaran(statusPenawaran);
        return penawaran;
    }

    @GetMapping(path = "/db/all")
    public List<Penawaran> findAll() {
        return penawaranRepository.findAll();
    }

    @GetMapping(path = "/bd/{id}")
    public Penawaran findById(@PathVariable long id) {
        return penawaranRepository.findById(id).get();
    }

}
