package io.github.surajto.skillhubbartersystemteamfusion.controller;

import io.github.surajto.skillhubbartersystemteamfusion.model.BarterRequest;
import io.github.surajto.skillhubbartersystemteamfusion.service.DatabaseBarterRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/barter")
public class BarterRequestController {

    private final DatabaseBarterRequestService barterRequestService;

    @Autowired
    public BarterRequestController(DatabaseBarterRequestService barterRequestService) {
        this.barterRequestService = barterRequestService;
    }

    @PostMapping
    public BarterRequest createBarterRequest(@RequestBody BarterRequest request) {
        return barterRequestService.createBarterRequest(request);
    }

    @GetMapping
    public List<BarterRequest> getAllRequests() {
        return barterRequestService.getAllRequests();
    }

    @GetMapping("/sender/{id}")
    public List<BarterRequest> getRequestsBySender(@PathVariable long id) {
        return barterRequestService.getRequestsBySender(id);
    }

    @GetMapping("/receiver/{id}")
    public List<BarterRequest> getRequestsByReceiver(@PathVariable long id) {
        return barterRequestService.getRequestsByReceiver(id);
    }

    @PutMapping("/{id}/status")
    public BarterRequest updateStatus(@PathVariable long id, @RequestParam String status) {
        return barterRequestService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteBarterRequest(@PathVariable long id) {
        barterRequestService.deleteBarterRequest(id);
    }
}