package com.crud.tasks.trello.client;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.trello.config.TrelloConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloClientTest {

    @InjectMocks
    TrelloClient trelloClient;
    @Mock
    TrelloConfig trelloConfig;
    @Mock
    RestTemplate restTemplate;

    @Test
    void getEmptyTrelloBoard() throws URISyntaxException {
        //Given
        URI uri = new URI("https://test.com/members/monikawalewska/boards?key=test&token=test&fields=name,id&lists=all");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("https://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        TrelloBoardDto[] boardDtos = new TrelloBoardDto[0];
        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(boardDtos);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloClient.getTrelloBoards();

        //Then
        assertEquals(0, trelloBoardDtoList.size());
    }

    @Test
    void getTrelloBoards() throws URISyntaxException {
        //Given
        URI uri = new URI("https://test.com/members/monikawalewska/boards?key=test&token=test&fields=name,id&lists=all");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("https://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        TrelloBoardDto[] boardDtos = new TrelloBoardDto[1];
        boardDtos[0] = new TrelloBoardDto("1", "test", new ArrayList<>());
        when(restTemplate.getForObject(uri, TrelloBoardDto[].class)).thenReturn(boardDtos);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloClient.getTrelloBoards();

        //Then
        assertEquals(1, trelloBoardDtoList.size());
        assertEquals("1", trelloBoardDtoList.get(0).getId());
    }

    @Test
    void createNewCard() throws URISyntaxException {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test", "test", "test", "1");
        URI uri = new URI("https://test.com/cards?key=test&token=test&name=test&desc=test&pos=test&idList=1");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("1", "test", "http://test.com");
        when(trelloConfig.getTrelloApiEndpoint()).thenReturn("https://test.com");
        when(trelloConfig.getTrelloAppKey()).thenReturn("test");
        when(trelloConfig.getTrelloToken()).thenReturn("test");
        when(restTemplate.postForObject(uri, null, CreatedTrelloCardDto.class)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto cardDto = trelloClient.createNewCard(trelloCardDto);

        //Then
        assertEquals("1", cardDto.getId());
        assertEquals("test", cardDto.getName());
        assertEquals("http://test.com", cardDto.getShortUrl());
    }
}