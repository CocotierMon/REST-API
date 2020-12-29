package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.dto.TrelloBoardDto;
import com.crud.tasks.dto.TrelloCardDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createdCard(trelloCardDto);
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
