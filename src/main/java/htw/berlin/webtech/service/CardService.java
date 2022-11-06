package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.CardEntity;
import htw.berlin.webtech.persistence.CardRepository;
import htw.berlin.webtech.webDemo.api.Card;
import htw.berlin.webtech.webDemo.api.CardManipulationRequest;
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
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Card findById(Long id) {
        var cardEntity = cardRepository.findById(id); //optional Objekt kann sagen, dass es leer ist ohne nullPointerException
        return cardEntity.map(this::transformEntity).orElse(null);
    }

    public Card create(CardManipulationRequest request) {
        var cardEntity = new CardEntity(request.getName(), request.getDescription(), request.getDueDate());
        cardEntity = cardRepository.save(cardEntity);
        return transformEntity(cardEntity);
    }

    public Card update(Long id, CardManipulationRequest request) {
        var cardEntityOptional = cardRepository.findById(id);
        if (cardEntityOptional.isEmpty()) {
            return null;
        }

        var cardEntity = cardEntityOptional.get();
        cardEntity.setName(request.getName());
        cardEntity.setDescription(cardEntity.getDescription());
        cardEntity.setDueDate(cardEntity.getDueDate());
        cardEntity = cardRepository.save(cardEntity);

        return transformEntity(cardEntity);
    }

    private Card transformEntity(CardEntity cardEntity) {
        return new Card(
                cardEntity.getId(),
                cardEntity.getName(),
                cardEntity.getDescription(),
                cardEntity.getDueDate()
        );
    }
}
