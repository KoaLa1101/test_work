package ru.itlab.test_work.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itlab.test_work.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
