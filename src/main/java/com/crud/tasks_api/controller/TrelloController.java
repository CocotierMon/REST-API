package com.crud.tasks_api.controller;

import com.crud.tasks_api.domain.CreatedTrelloCard;
import com.crud.tasks_api.dto.TrelloBoardDto;
import com.crud.tasks_api.dto.TrelloCardDto;
import com.crud.tasks_api.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createNewCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }
}

       /* if (boardsConditions()) {
            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

            trelloBoards.forEach(trelloBoardDto -> {

                System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

                System.out.println("This board contains lists: ");

                trelloBoardDto.getLists().forEach(trelloList ->
                        System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
            });*/


   /* private boolean boardsConditions() {
        List<TrelloBoardDto> trelloBoardsWithConditions = trelloClient.getTrelloBoards();

        for (TrelloBoardDto trelloBoardDto : trelloBoardsWithConditions) {
            if (trelloBoardDto.getName().contains("Kodilla")
                    && trelloBoardDto.getId() != null
                    && trelloBoardDto.getName() != null) {
                return true;
            }
            System.out.println("Brak listy, ktora spełnia warunki");
            return false;
        }
        return false;
    }*/
