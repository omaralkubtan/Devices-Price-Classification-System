package cc.maids.demo.controllers;

import cc.maids.demo.entities.Device;
import cc.maids.demo.services.DeviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("")
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Device device = deviceService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @PostMapping("")
    public Device addDevice(@RequestBody Device device) {
        return deviceService.createDevice(device);
    }

    @PostMapping("/predict/{deviceId}")
    public Device predictPrice(@PathVariable Long deviceId) throws JsonProcessingException {
        return deviceService.predictPrice(deviceId);
    }
}