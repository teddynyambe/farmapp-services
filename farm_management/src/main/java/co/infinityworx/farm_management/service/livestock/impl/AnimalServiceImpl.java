package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.AnimalEntity;
import co.infinityworx.farm_management.model.repository.livestock.AnimalRepository;
import co.infinityworx.farm_management.service.livestock.AnimalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 17:03
 * Project: user_management
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void saveAnimal(AnimalEntity animal) {
        if(animal.getAnimalId() == null) {
            animal.setAnimalId(UUID.randomUUID().toString());
        }
        this.animalRepository.save(animal);
    }

    @Override
    public List<AnimalEntity> getAllFarmAnimals(String farmId) {
        List<AnimalEntity> animals = this.animalRepository.findByFarmId(farmId);
        return animals;
    }

    @Override
    public AnimalEntity getFarmAnimalById(String animalId) {
        return this.animalRepository.findByAnimalId(animalId);
    }

    @Override
    public void deleteAnimal(String animalId) {
        this.animalRepository.deleteByAnimalId(animalId);
    }

    @Override
    public AnimalEntity getAnimalById(Long id) {
        return animalRepository.findById(id).get();
    }
}
