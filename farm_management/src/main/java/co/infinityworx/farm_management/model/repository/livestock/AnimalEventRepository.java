package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface AnimalEventRepository extends CrudRepository<AnimalEventEntity, Long> {
    void deleteByAnimalEventId(String animalEventId);
}
