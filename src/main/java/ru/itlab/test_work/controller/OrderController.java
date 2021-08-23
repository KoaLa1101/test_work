package ru.itlab.test_work.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itlab.test_work.model.Item;
import ru.itlab.test_work.model.Order;
import ru.itlab.test_work.model.dto.CreateOrderDto;
import ru.itlab.test_work.model.dto.SuccessCrudDto;
import ru.itlab.test_work.service.OrderService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/new")
    public String saveOrder(@Valid @RequestBody CreateOrderDto createOrderDto){
        orderService.createOrder(Item.from(createOrderDto.getItemDtoList()), createOrderDto.getEmailOfUser());
        return SuccessCrudDto.builder().message("Order saved successfully").status("200").toString();
    }

    @GetMapping("/email")
    public List<Order> getAllByEmail(@RequestParam String emailOfUser){
        return orderService.getAllByEmail(emailOfUser);
    }

    @GetMapping("/article/{article}")
    public List<Order> getAllByArticleOfItem(@PathVariable("article") String article){
        return orderService.getAllByArticleOfItem(article);
    }

    @SneakyThrows
    @GetMapping("/dates")
    public List<Order> getAllBetweenDated(@RequestParam String date1,@RequestParam String date2){
        Date firstDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date1);
        Date secondDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date2);
        return orderService.getAllBetweenDates(firstDate, secondDate);
    }
}
