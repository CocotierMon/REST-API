package com.crud.tasks_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TrelloCardDto {

    private String name;
    private String description;
    private String pos;
    private String listId;
    private String badges;

    public TrelloCardDto(String test_task, String test_description, String top, String test_id) {
    }
}
