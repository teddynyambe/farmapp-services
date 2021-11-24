package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.SpecieEntity;

import java.util.List;
import java.util.Map;

public interface SpecieService {
    void saveSpecie(SpecieEntity specie);
    SpecieEntity getSpecieById(Long id);
    SpecieEntity getSpecieBySpecieId(String specieId);
    List<Map<String, Object>> getAllSpecies(String owner);
    List<SpecieEntity> getAll();
}
