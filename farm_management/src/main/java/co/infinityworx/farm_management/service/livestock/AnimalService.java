package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEntity;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 18/07/2021
 * Time: 18:08
 * Project: user_management
 */
public interface AnimalService
{
    void saveAnimal(AnimalEntity animal);
    List<AnimalEntity> getAllFarmAnimals(String farmId);
    AnimalEntity getFarmAnimalById(String animalId);
    void deleteAnimal(String animalId);
    AnimalEntity getAnimalById(Long id);
}
