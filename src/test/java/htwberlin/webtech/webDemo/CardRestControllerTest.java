package htwberlin.webtech.webDemo;

import htwberlin.webtech.persistence.CardEntity;
import htwberlin.webtech.persistence.Register;
import htwberlin.webtech.service.CardService;
import htwberlin.webtech.webDemo.api.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardRestController.class)
public class CardRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService service;

    /*
    @Test
    @DisplayName("kp digga")
    public void testFetchCardsById() throws Exception {
        //Test Daten und Service Mock
        var card1 = new CardEntity("Card 1", "bla bla", LocalDateTime.of(2023, 1, 1, 17, 15, 0), Register.DONE, null);
        when(service.findById(1L)).thenReturn(card1);

        //Erwartetes Ergebnis
        String expected = "{\"id\":1,\"name\":\"Card 1\",\"bla bla\",\"dueDate\":\"01.01.2023 17:15.00\",\"register\":\"DONE\",\"label\":null}";

        //Aufruf und Vergleich
        this.mockMvc.perform(get("/cards/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
    */
}
