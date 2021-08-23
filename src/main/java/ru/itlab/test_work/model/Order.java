package ru.itlab.test_work.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "my_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfOrder;
    private String emailOfUser;
    private Date dateOfCreation;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Item> itemList;
}
