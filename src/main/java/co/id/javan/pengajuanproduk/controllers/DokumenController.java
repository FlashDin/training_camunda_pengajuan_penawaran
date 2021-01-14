package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Dokumen;
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
@RequestMapping("/api/task/dokumen")
public class DokumenController {

    @Autowired
    private CamundaProcessService camundaProcessService;
    @Inject
    private RuntimeService runtimeService;

    @GetMapping(path = "/active")
    public List<Dokumen> getActiveTasks(@RequestParam("taskDefinitionKey") String taskDefinitionKey) {
        List<Task> tasks = camundaProcessService.getActiveTasks(TaskVariable.processDefinitionKey, taskDefinitionKey);
        List<Dokumen> result = new ArrayList<>();
        for (Task task : tasks) {
            Dokumen dokumen = new Dokumen();
            dokumen.setId(task.getId());
            dokumen.setInstanceId(task.getProcessInstanceId());
            String pathDokumen = (String) runtimeService.getVariable(task.getProcessInstanceId(), "pathDokumen");
            Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
            dokumen.setPathDokumen(pathDokumen);
            dokumen.setPenawaran(penawaran);
            result.add(dokumen);
        }
        return result;
    }

    @GetMapping(path = "/{processInstanceId}")
    public Dokumen getTask(@RequestParam("taskDefinitionKey") String taskDefinitionKey,
                               @PathVariable("processInstanceId") String processInstanceId) {
        Task task = camundaProcessService.getTask(TaskVariable.processDefinitionKey, taskDefinitionKey, processInstanceId);
        Dokumen dokumen = new Dokumen();
        dokumen.setId(task.getId());
        dokumen.setInstanceId(task.getProcessInstanceId());
        String pathDokumen = (String) runtimeService.getVariable(task.getProcessInstanceId(), "pathDokumen");
        Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
        dokumen.setPathDokumen(pathDokumen);
        dokumen.setPenawaran(penawaran);
        return dokumen;
    }

}
