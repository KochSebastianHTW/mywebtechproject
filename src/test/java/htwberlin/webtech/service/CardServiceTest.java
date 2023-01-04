package htwberlin.webtech.service;

import htwberlin.webtech.persistence.CardEntity;
import htwberlin.webtech.persistence.CardRepository;
import htwberlin.webtech.persistence.LabelEntity;
import htwberlin.webtech.persistence.Register;
import htwberlin.webtech.webDemo.api.CardManipulationRequest;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest implements WithAssertions {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    @Test
    @DisplayName("should return true if delete was successful")
    void returnTrueIfDeleteSuccessful() {
        // given
        Long givenId = 10L;
        when(cardRepository.existsById(givenId)).thenReturn(true);

        // when
        boolean result = cardService.deleteById(givenId);

        // then
        verify(cardRepository).deleteById(givenId);
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("should return false if card to delete doesn't exists")
    void returnFalseIfCardToDeleteDoesntExists() {
        // given
        Long givenId = 10L;
        when(cardRepository.existsById(givenId)).thenReturn(false);

        // when
        boolean result = cardService.deleteById(givenId);

        // then
        verifyNoMoreInteractions(cardRepository);
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("should return the correct card by the id one is looking for")
    void ReturnCardWhenFindById() {
        // given
        var cardEntity = Mockito.mock(CardEntity.class);
        Long givenId = 10L;
        String name = "Test Purposes";
        String description = "try and test";
        LocalDateTime localDateTime = LocalDateTime.of(
                2022,
                12,
                24,
                18,
                0);
        when(cardEntity.getId()).thenReturn(givenId);
        when(cardEntity.getName()).thenReturn(name);
        when(cardEntity.getDescription()).thenReturn(description);
        when(cardEntity.getDueDate()).thenReturn(localDateTime);
        when(cardEntity.getRegister()).thenReturn(Register.OPEN);
        when(cardRepository.findById(givenId)).thenReturn(Optional.of(cardEntity));

        // when
        var result = cardService.findById(10L);

        // then
        assertThat(result.getId()).isEqualTo(givenId);
        assertThat(result.getName()).isEqualTo(name);
        assertThat(result.getDescription()).isEqualTo(description);
        assertThat(result.getDueDate()).isEqualTo(localDateTime);
        assertThat(result.getRegister()).isEqualTo("OPEN");
    }

    // Jap, hier läuft wat schief
    @Test
    @DisplayName("should return updated card after update")
    void returnUpdatedCardAfterUpdateRequest() {
        // given
        var labelEntity = new LabelEntity("Sollte gemacht werden", "#EED202");

        Long givenId = 1L;
        String name = "X-Mas";
        String descr = "yeah";
        LocalDateTime dueDate = LocalDateTime.of(
                2023,
                12,
                24,
                18,
                0
        );
        var cardEntity = new CardEntity(name, descr, dueDate, Register.DONE, labelEntity);

        var request = Mockito.mock(CardManipulationRequest.class);
        when(request.getName()).thenReturn(name);
        when(request.getDescription()).thenReturn(descr);
        when(request.getDueDate()).thenReturn(dueDate);
        when(request.getRegister()).thenReturn(Register.OPEN.toString());
        when(request.getLabelId()).thenReturn(null);

        when(cardRepository.findById(givenId)).thenReturn(Optional.of(cardEntity));
        when(cardRepository.save(cardEntity)).thenReturn(cardEntity);

        // when
        var result = cardService.update(givenId, request);

        // then
        assertThat(result.getDueDate()).isEqualTo(dueDate);
        assertThat(result.getRegister()).isEqualTo(Register.OPEN.toString());
        assertThat(result.getLabelId()).isEqualTo(null);
    }
}
