package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 16:22
 * Project: user_management
 */
public interface AnimalRepository extends CrudRepository<AnimalEntity, Long> {
    List<AnimalEntity> findByFarmId(String farmId);
    AnimalEntity findByAnimalId(String animalId);
    void deleteByAnimalId(String animal);
}
