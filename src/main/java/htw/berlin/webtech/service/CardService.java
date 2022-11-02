package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.CardEntity;
import htw.berlin.webtech.persistence.CardRepository;
import htw.berlin.webtech.webDemo.api.Card;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> findAll() {
        List<CardEntity> cards = cardRepository.findAll();
        return cards.stream()
                .map(cardEntity -> new Card(
                        cardEntity.getId(),
                        cardEntity.getName(),
                        cardEntity.getDescription(),
                        cardEntity.getDueDate()
                ))
                .collect(Collectors.toList());
    }
}
