package org.example.project_base_spring_mvc.model.entity;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskItem {

    private String id;

    @NotBlank(message = "Tên công việc không được để trống")
    @Size(min = 5, message = "Tên công việc phải có ít nhất 5 ký tự")
    private String title;

    @NotNull(message = "Hạn hoàn thành không được để trống")
    @Future(message = "Hạn hoàn thành bài phải là trong tương lai")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate deadline;

    @NotBlank(message = "Mức độ ưu tiên không được để trống")
    @Pattern(regexp = "HIGH|MEDIUM|LOW", message = "Ưu tiên chỉ được là HIGH, MEDIUM hoặc LOW")
    private String priority;

    public TaskItem() {
    }

    public TaskItem(String id, String title, LocalDate deadline, String priority) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}