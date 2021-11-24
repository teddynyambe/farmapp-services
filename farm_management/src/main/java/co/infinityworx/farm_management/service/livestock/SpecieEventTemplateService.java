package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.SpecieEventTemplateEntity;

public interface SpecieEventTemplateService {
    void saveSpecieEventTemplate(SpecieEventTemplateEntity specieEventTemplate);
    SpecieEventTemplateEntity getById(Long id);
}
