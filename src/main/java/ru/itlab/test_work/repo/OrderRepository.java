package ru.itlab.test_work.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.itlab.test_work.model.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getAllByEmailOfUser(String emailOfUser);

    @Query(nativeQuery = true, value = "select * from my_order inner join my_order_item_list on my_order.id=my_order_item_list.order_id inner join item on item.article=my_order_item_list.item_list_article where item.article=:param1")
    List<Order> getAllByArticle(@Param("param1") String article);

    @Query(nativeQuery = true, value = "select * from my_order where my_order.date_of_creation between :param1 and :param2")
    List<Order> getAllBetweenDates(@Param("param1")Date date1, @Param("param2")Date date2);

}
