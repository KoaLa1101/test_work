package ru.itlab.test_work.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.test_work.model.Item;
import ru.itlab.test_work.model.Order;
import ru.itlab.test_work.repo.OrderRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void createOrder(List<Item> itemList, String email_of_user){
        Order order = Order.builder()
                .nameOfOrder(getHashByDateAndTime())
                .emailOfUser(email_of_user)
                .dateOfCreation(getActualDateAndTime())
                .itemList(itemList)
                .build();

        orderRepository.save(order);
    }

    public List<Order> getAllByEmail(String email){
        return orderRepository.getAllByEmailOfUser(email);
    }

    public List<Order> getAllByArticleOfItem(String article){
        return orderRepository.getAllByArticle(article);
    }

    public List<Order> getAllBetweenDates(Date date1, Date date2){
        return orderRepository.getAllBetweenDates(date1, date2);
    }

    private String getHashByDateAndTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss_dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    private Date getActualDateAndTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return new Date(dtf.format(LocalDateTime.now()));
    }



}
