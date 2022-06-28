package paley.yuri.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import paley.yuri.entity.Item;

public interface ItemsRepository extends JpaRepositoryImplementation<Item, Long> {}
