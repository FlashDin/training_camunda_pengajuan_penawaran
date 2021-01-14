package co.id.javan.pengajuanproduk.controllers;

import co.id.javan.pengajuanproduk.pojo.Distributor;
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
@RequestMapping("/api/task/distributor")
public class DistributorController {

    @Autowired
    private CamundaProcessService camundaProcessService;
    @Inject
    private RuntimeService runtimeService;

    @GetMapping(path = "/active")
    public List<Distributor> getActiveTasks(@RequestParam("taskDefinitionKey") String taskDefinitionKey) {
        List<Task> tasks = camundaProcessService.getActiveTasks(TaskVariable.processDefinitionKey, taskDefinitionKey);
        List<Distributor> result = new ArrayList<>();
        for (Task task : tasks) {
            Distributor distributor = new Distributor();
            distributor.setId(task.getId());
            distributor.setInstanceId(task.getProcessInstanceId());
            String namaDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaDistributor");
            String npwpDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "npwpDistributor");
            String emailDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "emailDistributor");
            Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
            distributor.setNamaDistributor(namaDistributor);
            distributor.setNpwpDistributor(npwpDistributor);
            distributor.setEmailDistributor(emailDistributor);
            distributor.setPenawaran(penawaran);
            result.add(distributor);
        }
        return result;
    }

    @GetMapping(path = "/{processInstanceId}")
    public Distributor getTask(@RequestParam("taskDefinitionKey") String taskDefinitionKey,
                               @PathVariable("processInstanceId") String processInstanceId) {
        Task task = camundaProcessService.getTask(TaskVariable.processDefinitionKey, taskDefinitionKey, processInstanceId);
        Distributor distributor = new Distributor();
        distributor.setId(task.getId());
        distributor.setInstanceId(task.getProcessInstanceId());
        String namaDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "namaDistributor");
        String npwpDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "npwpDistributor");
        String emailDistributor = (String) runtimeService.getVariable(task.getProcessInstanceId(), "emailDistributor");
        Penawaran penawaran = (Penawaran) runtimeService.getVariable(task.getProcessInstanceId(), "penawaran");
        distributor.setNamaDistributor(namaDistributor);
        distributor.setNpwpDistributor(npwpDistributor);
        distributor.setEmailDistributor(emailDistributor);
        distributor.setPenawaran(penawaran);
        return distributor;
    }

}
