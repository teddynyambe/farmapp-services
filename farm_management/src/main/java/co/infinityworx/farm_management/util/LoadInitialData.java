package co.infinityworx.farm_management.util;

import co.infinityworx.farm_management.model.entity.livestock.*;
import co.infinityworx.farm_management.model.repository.livestock.FarmRepository;
import co.infinityworx.farm_management.service.livestock.*;
import co.infinityworx.farm_management.util.enums.SizeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: Teddy Nyambe - InfinityWORX
 * Date: 17/07/2021
 * Time: 17:38
 * Project: user_management
 */
@Component
public class LoadInitialData implements CommandLineRunner {
    private FarmService farmService;
    private SpecieService specieService;
    private CrashPenService crashPenService;
    private SpecieEventTemplateService specieEventTemplateService;
    private CrashPenEventTemplateService crashEventTemplateService;
    private FarmRepository farmRepository;
    private AnimalEventService animalEventService;
    private AnimalService animalService;
    private LivesStockFarmActivityService livesStockFarmActivityService;

    private Logger logger = LoggerFactory.getLogger(LoadInitialData.class);

    public LoadInitialData(FarmService farmService, SpecieService specieService, CrashPenService crashPenService, SpecieEventTemplateService specieEventTemplateService, CrashPenEventTemplateService crashEventTemplateService, FarmRepository farmRepository, AnimalEventService animalEventService, AnimalService animalService, LivesStockFarmActivityService livesStockFarmActivityService) {
        this.farmService = farmService;
        this.specieService = specieService;
        this.crashPenService = crashPenService;
        this.specieEventTemplateService = specieEventTemplateService;
        this.crashEventTemplateService = crashEventTemplateService;
        this.farmRepository = farmRepository;
        this.animalEventService = animalEventService;
        this.animalService = animalService;
        this.livesStockFarmActivityService = livesStockFarmActivityService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("================= Loading data started =============");
        ///ADD FARM
        FarmEntity farm = new FarmEntity(
                null,
                null,
                "Chitwe Farms",
                30.0, SizeType.Hectares,
                "6d4957f5-9a42-467d-b78c-04373f2d9e03",
                new AddressEntity(
                        null,
                        "Farm No. 228",
                        "Off Kafubu Block Road",
                        "13.0989898",
                        "0.88w7727",
                        "+260977760473",
                        "Luanshya",
                        "Copperbelt",
                        "zm",
                        "Kafubu Block"), null
        );
        this.farmService.saveFarm(farm);
        /// Load Data on Species
        specieService.saveSpecie(new SpecieEntity(null, "6d4957xf-9a42-467d-b78c-04373f2d9exf", "cattle"));
        specieService.saveSpecie(new SpecieEntity(null, "y24957f5-9axf-467d-b7xf-04373f2d9e03", "goat"));
        specieService.saveSpecie(new SpecieEntity(null, "xf4957f5-9a42-467d-b78c-xf373f2d9e03", "chicken"));
        specieService.saveSpecie(new SpecieEntity(null, "2957f5-9a42-467d-b78c-04373f2d9e03e", "pig"));
        /// Load Livestock activity
        livesStockFarmActivityService.saveFarmActivity(new LiveStockFarmActivityEntity(null,  specieService.getSpecieBySpecieId("6d4957xf-9a42-467d-b78c-04373f2d9exf"), farmService.getFarmById(1L).getFarmId(), "6d4957f5-9a42-467d-b78c-04373f2d9e03"));
        livesStockFarmActivityService.saveFarmActivity(new LiveStockFarmActivityEntity(null, specieService.getSpecieBySpecieId("xf4957f5-9a42-467d-b78c-xf373f2d9e03"), farmService.getFarmById(1L).getFarmId(), "6d4957f5-9a42-467d-b78c-04373f2d9e03"));
        /// Load Data on CrashPens
        crashPenService.saveCrashPen(new CrashPenEntity(null, null, "main pen", farmService.getFarmById(1L)));
        // Load Template Data - Specie
        specieEventTemplateService.saveSpecieEventTemplate(new SpecieEventTemplateEntity(null, null, this.specieService.getSpecieById(3L), "Birth", 1L));
        specieEventTemplateService.saveSpecieEventTemplate(new SpecieEventTemplateEntity(null, null, this.specieService.getSpecieById(3L), "Castration", 2L));
        specieEventTemplateService.saveSpecieEventTemplate(new SpecieEventTemplateEntity(null, null, this.specieService.getSpecieById(3L), "Vaccination - Lump-skin", 3L));
        specieEventTemplateService.saveSpecieEventTemplate(new SpecieEventTemplateEntity(null, null, this.specieService.getSpecieById(3L), "Vaccination - De-warmer", 4L));
        // Load Template Data - Crash pens
        this.crashEventTemplateService.saveCrashPenTemplate(new CrashPenEventTemplateEntity(null, null, "Spray", 1L));
        this.crashEventTemplateService.saveCrashPenTemplate(new CrashPenEventTemplateEntity(null, null, "Vaccination - De-warmer", 2L));
        this.crashEventTemplateService.saveCrashPenTemplate(new CrashPenEventTemplateEntity(null, null, "Maintenance", 3L));
        this.crashEventTemplateService.saveCrashPenTemplate(new CrashPenEventTemplateEntity(null, null, "Treatment", 4L));

        // Load Animal
        this.animalService.saveAnimal(new AnimalEntity(null, null, farmService.getFarmById(1L).getFarmId(), "tag:90900", specieService.getSpecieById(3L), "Bullet", LocalDate.now(), null, null, null, null));
        // Load Animal Event
        //this.animalEventService.saveAnimalEvent(new AnimalEventEntity(null, null, animalService.getAnimalById(16L), "dewomer",specieEventTemplateService.getById(8L), LocalDateTime.now()));
        //this.animalEventService.saveAnimalEvent(new AnimalEventEntity(null, null, animalService.getAnimalById(16L), "oxject", specieEventTemplateService.getById(10L), LocalDateTime.now()));


        logger.info("================= Loading data ended =============");
    }
}
