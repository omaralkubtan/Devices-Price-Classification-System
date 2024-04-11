package cc.maids.demo.services;

import cc.maids.demo.entities.Device;
import cc.maids.demo.exceptions.ResourceNotFoundException;
import cc.maids.demo.repositories.DeviceRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Transactional
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }


    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + id));
    }

    @Transactional
    public Device predictPrice(Long deviceId) throws JsonProcessingException {
        Device device = deviceRepository.findById(deviceId).orElseThrow(() -> new ResourceNotFoundException("Device not found with id " + deviceId));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Device> entity = new HttpEntity<>(device, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange("http://127.0.0.1:5000/api/predict", HttpMethod.POST, entity, String.class);

        // retrieve the value of prediction from the json response
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(response.getBody());
        String prediction = rootNode.path("prediction").asText();

        assert prediction != null;
        device.setPriceRange(Integer.parseInt(prediction));
        deviceRepository.save(device);

        return device;
    }
}