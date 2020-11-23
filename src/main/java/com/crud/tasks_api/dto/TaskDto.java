package com.crud.tasks_api.dto;

import lombok.AllArgsConstructor;

import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDto {
    private long id;
    private String title;
    private String content;
}
