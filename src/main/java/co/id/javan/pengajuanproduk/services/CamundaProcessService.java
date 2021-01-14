package co.id.javan.pengajuanproduk.services;

import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CamundaProcessService {

    @Inject
    private TaskService taskService;

    public List<Task> getTasks(String processDefinitionKey) {
        return taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .list();
    }

    public List<Task> getActiveTasks(String processDefinitionKey, String taskDefinitionKey) {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey)
                .list();
        return tasks;
    }

    public Task getTask(String processDefinitionKey, String taskDefinitionKey, String processInstanceId) {
        return taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey)
                .processInstanceId(processInstanceId)
                .active()
                .singleResult();
    }

}
