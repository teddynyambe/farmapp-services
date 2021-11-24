package co.infinityworx.farm_management.service.livestock.impl;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEventTemplateEntity;
import co.infinityworx.farm_management.model.repository.livestock.CrashPenEventTemplateRepository;
import co.infinityworx.farm_management.service.livestock.CrashPenEventTemplateService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 13:53
 * Project: farm_management
 */
@Service
public class CrashPenEventTemplateServiceImpl implements CrashPenEventTemplateService {
    private CrashPenEventTemplateRepository crashPenEventTemplateRepository;

    public CrashPenEventTemplateServiceImpl(CrashPenEventTemplateRepository crashPenEventTemplateRepository) {
        this.crashPenEventTemplateRepository = crashPenEventTemplateRepository;
    }

    @Override
    public void saveCrashPenTemplate(CrashPenEventTemplateEntity crashPenEventTemplate) {
        if(crashPenEventTemplate.getCrashPenEventId() == null){
            crashPenEventTemplate.setCrashPenEventId(UUID.randomUUID().toString());
        }
        this.crashPenEventTemplateRepository.save(crashPenEventTemplate);
    }

    @Override
    public CrashPenEventTemplateEntity getCrashPenEventTemplateById(Long id) {
        return this.crashPenEventTemplateRepository.findById(id).get();
    }
}
