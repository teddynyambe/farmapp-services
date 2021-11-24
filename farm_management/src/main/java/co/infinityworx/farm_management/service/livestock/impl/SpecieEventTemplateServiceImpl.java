package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.SpecieEventTemplateEntity;
import co.infinityworx.farm_management.model.repository.livestock.SpecieEventTemplateRepository;
import co.infinityworx.farm_management.service.livestock.SpecieEventTemplateService;
import org.springframework.stereotype.Service;

import java.util.UUID;


/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 13:05
 * Project: farm_management
 */
@Service
public class SpecieEventTemplateServiceImpl implements SpecieEventTemplateService {
    private SpecieEventTemplateRepository specieEventTemplateRepository;

    public SpecieEventTemplateServiceImpl(SpecieEventTemplateRepository specieEventTemplateRepository) {
        this.specieEventTemplateRepository = specieEventTemplateRepository;
    }

    @Override
    public void saveSpecieEventTemplate(SpecieEventTemplateEntity specieEventTemplate) {
        if (specieEventTemplate.getSpecieEventId() == null) {
            specieEventTemplate.setSpecieEventId(UUID.randomUUID().toString());
        }
        this.specieEventTemplateRepository.save(specieEventTemplate);
    }

    @Override
    public SpecieEventTemplateEntity getById(Long id) {
        return specieEventTemplateRepository.findById(id).get();
    }
}
