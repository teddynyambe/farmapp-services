package co.infinityworx.farm_management.model.repository.livestock;

import co.infinityworx.farm_management.model.entity.livestock.SpecieEntity;
import org.springframework.data.repository.CrudRepository;

public interface SpecieRepository extends CrudRepository<SpecieEntity, Long> {
    SpecieEntity findBySpecieId(String specieId);
}
