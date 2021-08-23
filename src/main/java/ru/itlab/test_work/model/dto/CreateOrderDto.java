package ru.itlab.test_work.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderDto {
    @Email(message = "invalid email")
    private String emailOfUser;

    private List<ItemDto> itemDtoList;


}
