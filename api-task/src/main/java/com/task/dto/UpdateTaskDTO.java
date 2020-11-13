package com.task.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateTaskDTO {
    
    @NotNull(message = "Description can't be null.")
    @NotBlank(message = "Description can't be blank.")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
