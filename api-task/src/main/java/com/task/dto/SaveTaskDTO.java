package com.task.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SaveTaskDTO {

    @NotNull(message = "Description can't be null.")
    @NotBlank(message = "Description can't be blank.")
    private String description;

    @NotNull(message = "User can't be null.")
    private Integer idUser;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

}
