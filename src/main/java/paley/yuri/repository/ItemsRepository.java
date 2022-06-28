package paley.yuri.repository;

import paley.yuri.entity.Item;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface ItemsRepository extends JpaRepositoryImplementation<Item, Long> {

}
