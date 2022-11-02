package htw.berlin.webtech.demo.api;

import java.util.ArrayList;
import java.util.List;

public class Register {

    private int id;
    private String name;
    private List<Card> cardList;

    public Register(int id, String name) {
        this.id = id;
        this.name = name;
        this.cardList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }
}
