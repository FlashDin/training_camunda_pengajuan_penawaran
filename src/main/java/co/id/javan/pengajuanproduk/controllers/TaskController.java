package co.id.javan.pengajuanproduk.controllers;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Inject
    private TaskService taskService;
    @Inject
    private RuntimeService runtimeService;

    @GetMapping(path = "")
    public List<Map<String, Object>> listTask(@RequestParam("processDefinitionKey") String processDefinitionKey,
                                              @RequestParam("taskDefinitionKey") String taskDefinitionKey) {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(processDefinitionKey)
                .taskDefinitionKey(taskDefinitionKey)
                .list();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Task task : tasks) {
            Map<String, Object> row = new HashMap<>();
            row.put("id", task.getId());
            String nama = (String) runtimeService.getVariable(task.getProcessInstanceId(), "nama");
            row.put("instanceId", task.getProcessInstanceId());
            row.put("nama", nama);
            result.add(row);
        }
        return result;
    }

}
