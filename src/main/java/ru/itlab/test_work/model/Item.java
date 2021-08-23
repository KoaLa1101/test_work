package ru.itlab.test_work.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import ru.itlab.test_work.model.dto.ItemDto;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@Getter
@Setter
@Table(name = "item")
public class Item {
    @Id
    private String article;
    private String itemName;
    private Double cost;
    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        DELETED, AVAILABLE
    }

    public static Item from(ItemDto itemDto) {
        return Item.builder()
                .article(itemDto.getArticle())
                .itemName(itemDto.getItemName())
                .cost(itemDto.getCost())
                .state(State.AVAILABLE).build();
    }

    public static List<Item> from(List<ItemDto> listItemDto) {
        return listItemDto.stream().map(Item::from).collect(Collectors.toList());
    }


}
