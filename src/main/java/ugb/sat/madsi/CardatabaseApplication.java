package ugb.sat.madsi;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ugb.sat.madsi.domain.CarRepository;
import ugb.sat.madsi.domain.Car;
import ugb.sat.madsi.domain.OwnerRepository;
import ugb.sat.madsi.domain.Owner;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    private final CarRepository repository;
    private final OwnerRepository orepository;

    public CardatabaseApplication(CarRepository repository, OwnerRepository orepository) {
        this.repository = repository;
        this.orepository = orepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        orepository.saveAll(Arrays.asList(owner1, owner2));

        repository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2023, 59000, owner1));
        repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2020, 29000, owner2));
        repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2022, 39000, owner2));

        // Fetch all cars and log to console
        for (Car car : repository.findAll()) {
            logger.info("brand: {}, model: {}", car.getBrand(), car.getModel());
        }
    }

    @Bean
    public CarEventHandler carEventHandler() {
        return new CarEventHandler();
    }
}