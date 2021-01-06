package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TrelloValidatorTest {

    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    void validateTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("2", "nowe", new ArrayList<>()));

        //When
        List<TrelloBoard> validatedTrelloBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, validatedTrelloBoards.size());
    }

    @Test
    void validateCard() {
        //Given
        TrelloCard trelloCard = new TrelloCard("test", "test", "test", "test");
        //When
        trelloValidator.validateCard(trelloCard);
    }
}