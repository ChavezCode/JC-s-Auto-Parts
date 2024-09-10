package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // an if statement to prevent this inventory from duplicating each time the program is ran.
        if (outsourcedPartRepository.count() == 0) {

            //creating an object Oil Filter from the OutsourcedPart class
            OutsourcedPart oilFilter = new OutsourcedPart();
            oilFilter.setName("Oil Filter");
            oilFilter.setInv(15);
            oilFilter.setPrice(11.99);
            oilFilter.setId(021354);
            //saving the part to the Outsourced Part Repository
            outsourcedPartRepository.save(oilFilter);

            //creating an object Radiator Hose from the OutsourcedPart class
            OutsourcedPart radiatorHose = new OutsourcedPart();
            radiatorHose.setName("Radiator Hose");
            radiatorHose.setInv(20);
            radiatorHose.setPrice(20.50);
            radiatorHose.setId(021355);
            //saving the part to the Outsourced Part Repository
            outsourcedPartRepository.save(radiatorHose);

            //creating an object Water Pump from the OutsourcedPart class
            OutsourcedPart waterPump = new OutsourcedPart();
            waterPump.setName("Water Pump");
            waterPump.setInv(20);
            waterPump.setPrice(20.50);
            waterPump.setId(021356);
            //saving the part to the Outsourced Part Repository
            outsourcedPartRepository.save(waterPump);

            //creating an object Radiator from the OutsourcedPart class
            OutsourcedPart radiator = new OutsourcedPart();
            radiator.setName("Radiator");
            radiator.setInv(25);
            radiator.setPrice(79.99);
            radiator.setId(021357);
            //saving the part to the Outsourced Part Repository
            outsourcedPartRepository.save(radiator);

            //creating an object Drain Plug from the OutsourcedPart class
            OutsourcedPart drainPlug= new OutsourcedPart();
            drainPlug.setName("Drain Plug");
            drainPlug.setInv(20);
            drainPlug.setPrice(20.50);
            drainPlug.setId(021353);
            //saving the part to the Outsourced Part Repository
            outsourcedPartRepository.save(drainPlug);

        }

        if (productRepository.count() == 0) {

            //creating an object Turbo Kit from the Product class
            Product turboKit = new Product(1324, "Turbo Kit", 350.00, 5);
            //Saving the product to the product repository
            productRepository.save(turboKit);

            //creating an object coolant kit from the product class
            Product coolantKit = new Product(1332, "Coolant Kit", 180.50, 6);
            //saving the product to the product repository
            productRepository.save(coolantKit);

            //creating an object tool set from the product class
            Product toolSet  = new Product(1337, "Tool Set", 25.00, 30);
            //saving the product to the product repository
            productRepository.save(toolSet);

            //creating an object cleaning kit to the product class
            Product cleaningKit = new Product(1338, "Cleaning Kit", 25.00, 20);
            //saving the product to the product repository
            productRepository.save(cleaningKit);

            //creating an object break set from the product class
            Product breakSet = new Product(1339, "Break Set", 25.00, 20);
            //saving the product to the product repository
            productRepository.save(breakSet);


        }

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
