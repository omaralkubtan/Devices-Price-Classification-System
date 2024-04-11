package cc.maids.demo.configs;

import cc.maids.demo.entities.Device;
import cc.maids.demo.repositories.DeviceRepository;
import cc.maids.demo.services.DeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.io.*;
import java.util.Arrays;

@Configuration
public class SeedConfig {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceService deviceService;

    @EventListener
    public void seed(ContextRefreshedEvent event) throws IOException {
        seedDatabaseFromCSVFile();
        predictSome();
    }

    // This will predict the first 10 examples in the test data
    public void predictSome() throws JsonProcessingException {
        int count = 0;
        for (Device device : deviceRepository.findAll())
        {
            if(count == 10)
                break;
            var dev = deviceService.predictPrice(device.getId());
            System.out.println("Predicted Price for Device " + dev.getId() + " is : " + dev.getPriceRange());
            count++;
        }
    }

    public void seedDatabaseFromCSVFile() throws IOException {
        Reader in = new FileReader("src/main/java/cc/maids/demo/configs/test.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        int count = 0;
        for (CSVRecord record : records) {
            if(count == 0)
            {
                count++;
                continue;
            }

            if (count < 10)
                System.out.println("Row " + count + ": " + record.toString());

            Device device = new Device();
            device.setId((long) Integer.parseInt(record.get(0)));
            device.setBatteryPower(Integer.parseInt(record.get(1)));
            device.setBlue(Integer.parseInt(record.get(2)));
            device.setClockSpeed(Double.parseDouble(record.get(3)));
            device.setDualSim(Integer.parseInt(record.get(4)));
            device.setFc(Integer.parseInt(record.get(5)));
            device.setFourG(Integer.parseInt(record.get(6)));
            device.setIntMemory(Integer.parseInt(record.get(7)));
            device.setMDep(Double.parseDouble(record.get(8)));
            device.setMobileWt(Integer.parseInt(record.get(9)));
            device.setNCores(Integer.parseInt(record.get(10)));
            device.setPc(Integer.parseInt(record.get(11)));
            device.setPxHeight(Integer.parseInt(record.get(12)));
            device.setPxWidth(Integer.parseInt(record.get(13)));
            device.setRam(Integer.parseInt(record.get(14)));
            device.setScH(Integer.parseInt(record.get(15)));
            device.setScW(Integer.parseInt(record.get(16)));
            device.setTalkTime(Integer.parseInt(record.get(17)));
            device.setThreeG(Integer.parseInt(record.get(18)));
            device.setTouchScreen(Integer.parseInt(record.get(19)));
            device.setWifi(Integer.parseInt(record.get(20)));

            deviceRepository.save(device);
            count ++;
        }
    }
}
