package org.example.project_base_spring_mvc.controller;

import jakarta.validation.Valid;
import org.example.project_base_spring_mvc.model.entity.TaskItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final List<TaskItem> taskItems = new ArrayList<>();

    public TaskController() {
        taskItems.add(new TaskItem("T001", "Hoàn thành bài tập về nhà", LocalDate.now().plusDays(2), "HIGH"));
        taskItems.add(new TaskItem("T002", "Xem video chuẩn bị bài mới", LocalDate.now().plusDays(5), "MEDIUM"));
        taskItems.add(new TaskItem("T003", "Tham gia thảo luận nhóm", LocalDate.now().plusDays(3), "LOW"));
    }

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", taskItems);
        return "task-list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("taskItem", new TaskItem());
        return "task-form";
    }

    @PostMapping
    public String createTask(@Valid @ModelAttribute("taskItem") TaskItem taskItem,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("taskItem", taskItem);
            return "task-form";
        }

        taskItems.add(taskItem);
        return "redirect:/tasks";
    }
}
