package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.*;
import htw.berlin.webtech.webDemo.api.Card;
import htw.berlin.webtech.webDemo.api.CardManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private final CardRepository cardRepository;

    @Autowired
    private final LabelRepository labelRepository;

    public CardService(CardRepository cardRepository, LabelRepository labelRepository) {
        this.cardRepository = cardRepository;
        this.labelRepository = labelRepository;
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

    public List<Card> findByName(String search) {
        List<CardEntity> cards = cardRepository.findByNameContainsIgnoreCase(search);
        return cards.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Card create(CardManipulationRequest request) {
        var register = Register.valueOf(request.getRegister());
        var label = request.getLabel() != null ? labelRepository.findById(request.getLabel()).orElseThrow() : null;
        var cardEntity = new CardEntity(request.getName(), request.getDescription(), request.getDueDate(), register, label);
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
        cardEntity.setDescription(request.getDescription());
        cardEntity.setDueDate(request.getDueDate());
        cardEntity.setRegister(Register.valueOf(request.getRegister()));

        var labelEntity = request.getLabel() != null ? request.getLabel() : null;
        if (labelEntity != null) {
            cardEntity.setLabel(labelRepository.findById(labelEntity).orElseThrow());
        } else {
            cardEntity.setLabel(null);
        }
        cardEntity = cardRepository.save(cardEntity);

        return transformEntity(cardEntity);
    }

    public boolean deleteById(Long id) {
        if (!cardRepository.existsById(id)) {
            return false;
        }

        cardRepository.deleteById(id);
        return true;
    }

    private Card transformEntity(CardEntity cardEntity) {
        var register = cardEntity.getRegister().name();
        var labelId = cardEntity.getLabel() != null ? cardEntity.getLabel().getId() : null;
        return new Card(
                cardEntity.getId(),
                cardEntity.getName(),
                cardEntity.getDescription(),
                cardEntity.getDueDate(),
                register,
                labelId
        );
    }
}
