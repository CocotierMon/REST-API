package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.dto.TaskDto;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.dto.TrelloListDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@ExtendWith(MockitoExtension.class)
public class MappersTestSuite {

    @InjectMocks
    TaskMapper taskMapper;
    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    public void testTaskMapper() {
        //Given
        Task task = new Task(1L, "test 1", "test content 1");
        Task task1 = new Task(2L, "test 2", "test content 2");

        TaskDto taskDto = new TaskDto(1L, "test dto 1", "test content dto 1");
        TaskDto taskDto1 = new TaskDto(2L, "test dto 2", "test content dto 2");

        List<Task> tasks = new ArrayList<>();
        List<TaskDto> tasksDto;

        //When
        tasks.add(task);
        tasks.add(task1);

        tasksDto = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(tasks.size(), tasksDto.size());

        assertEquals(task.getId(), taskMapper.mapToTaskDto(task).getId());
        assertEquals(task.getTitle(), taskMapper.mapToTaskDto(task).getTitle());
        assertEquals(task.getContent(), taskMapper.mapToTaskDto(task).getContent());
        assertEquals(task1.getContent(), taskMapper.mapToTaskDto(task1).getContent());

        assertEquals(taskDto.getId(), taskMapper.mapToTask(taskDto).getId());
        assertEquals(taskDto.getTitle(), taskMapper.mapToTask(taskDto).getTitle());
        assertEquals(taskDto.getContent(), taskMapper.mapToTask(taskDto).getContent());
        assertEquals(taskDto1.getTitle(), taskMapper.mapToTask(taskDto1).getTitle());
    }

    @Test
    public void testTrelloMapper() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test card", "test card", "test card", "1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("test cdto", "test cdto", "test cdto", "2");
        TrelloBoard trelloBoard = new TrelloBoard("3", "test board", new ArrayList<>());
        TrelloListDto trelloListDto = new TrelloListDto("4", "test listdto", true);

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        List<TrelloList> trelloLists;
        List<TrelloBoardDto> trelloBoardDtos;
        List<TrelloListDto> trelloListDtos = new ArrayList<>();

        //When
        trelloListDtos.add(trelloListDto);
        trelloBoardList.add(trelloBoard);

        trelloLists = trelloMapper.mapToList(trelloListDtos);
        trelloListDtos = trelloMapper.mapToListDto(trelloLists);
        trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoardList);
        trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(1,trelloLists.size());
        assertEquals(1,trelloBoardList.size());

        assertEquals(trelloBoardList.get(0).getId(),trelloBoardDtos.get(0).getId());
        assertEquals(trelloBoardList.get(0).getName(),trelloBoardDtos.get(0).getName());
        assertEquals(trelloBoardList.get(0).getLists(),trelloBoardDtos.get(0).getLists());

        assertEquals(trelloLists.get(0).getId(),trelloListDtos.get(0).getId());
        assertEquals(trelloLists.get(0).getName(),trelloListDtos.get(0).getName());
        assertEquals(trelloLists.get(0).isClosed(),trelloListDtos.get(0).isClosed());

        assertSame(trelloCard.getDescription(), trelloMapper.mapToCardDto(trelloCard).getDescription());
        assertSame(trelloCardDto.getName(), trelloMapper.mapToCard(trelloCardDto).getName());
    }
}

