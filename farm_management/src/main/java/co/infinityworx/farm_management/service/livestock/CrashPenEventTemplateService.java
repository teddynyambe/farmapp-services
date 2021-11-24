package co.infinityworx.farm_management.service.livestock;

import co.infinityworx.farm_management.model.entity.livestock.CrashPenEventTemplateEntity;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 19/07/2021
 * Time: 13:35
 * Project: farm_management
 */
public interface CrashPenEventTemplateService {
    void saveCrashPenTemplate(CrashPenEventTemplateEntity crashPenEventTemplate);
    CrashPenEventTemplateEntity getCrashPenEventTemplateById(Long id);
}
