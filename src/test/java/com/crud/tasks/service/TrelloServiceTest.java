package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {

    @InjectMocks
    TrelloService trelloService;
    @Mock
    TrelloClient trelloClient;
    @Mock
    SimpleEmailService emailService;
    @Mock
    AdminConfig adminConfig;

    @Test
    void fetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> boardDtos = new ArrayList<>();
        boardDtos.add(new TrelloBoardDto("1", "test", new ArrayList<>()));
        when(trelloClient.getTrelloBoards()).thenReturn(boardDtos);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloService.fetchTrelloBoards();

        //Then
        assertEquals(1, trelloBoardDtoList.size());
    }

    @Test
    void createTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        CreatedTrelloCardDto cratedCard = new CreatedTrelloCardDto("1", "test", "http://test.com");
        when(adminConfig.getAdminMail()).thenReturn("test@test.com");
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(cratedCard);

        //When
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertEquals("1", createdTrelloCardDto.getId());
    }
}