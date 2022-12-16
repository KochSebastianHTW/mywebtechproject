package htwberlin.webtech.webDemo.service;

import htwberlin.webtech.persistence.CardEntity;
import htwberlin.webtech.persistence.CardRepository;
import htwberlin.webtech.persistence.Register;
import htwberlin.webtech.service.CardService;
import htwberlin.webtech.webDemo.api.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CardServiceTest {

    @Autowired
    private CardService service;

    @MockBean
    private CardRepository repository;

    String name1 = "Card 1";
    CardEntity card1 = new CardEntity(name1, "bla bla", LocalDateTime.of(2023,1,1,17,15, 0), Register.DONE,null);
    CardEntity card2 = new CardEntity("Card number 2", "bli bla blub", LocalDateTime.of(2023,1,2,17,20,0), Register.OPEN,null);
    CardEntity card3 = new CardEntity("Card number 3", "Dings Bums", LocalDateTime.of(2023,1,3,17,25,0), Register.OPEN,null);


    /*
    @Test
    @DisplayName("sollte eine Liste von Karten anhand des Namen finden")
    void testFindAll() {
        doReturn(List.of(Optional.of(card2), Optional.of(card3))).when(repository).findByNameContainsIgnoreCase(search);

        String search = "number";
        List<Card> actual = service.findByName(search);
        var expected = List.of(Optional.of(card2), Optional.of(card3));
        expected.stream().map(this::transformEntity).orElse(null);
        assertEquals(actual, expected);
    }
    */


    @Test
    @DisplayName("sollte eine Karte durch die Id finden")
    void testFindById() {
        doReturn(Optional.of(card1)).when(repository).findById(10L);

        Card actual = service.findById(10L);
        String expected = name1;

        assertEquals(actual.getName(), expected);
    }
}
