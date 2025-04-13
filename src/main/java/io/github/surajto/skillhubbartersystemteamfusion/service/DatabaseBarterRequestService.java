package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.BarterRequest;
import io.github.surajto.skillhubbartersystemteamfusion.repository.BarterRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseBarterRequestService {

    private final BarterRequestRepository barterRequestRepository;

    @Autowired
    public DatabaseBarterRequestService(BarterRequestRepository barterRequestRepository) {
        this.barterRequestRepository = barterRequestRepository;
    }

    public BarterRequest createBarterRequest(BarterRequest request) {
        return barterRequestRepository.save(request);
    }

    public List<BarterRequest> getAllRequests() {
        return barterRequestRepository.findAll();
    }

    public List<BarterRequest> getRequestsBySender(long senderId) {
        return barterRequestRepository.findBySenderId(senderId);
    }

    public List<BarterRequest> getRequestsByReceiver(long receiverId) {
        return barterRequestRepository.findByReceiverId(receiverId);
    }

    public BarterRequest updateStatus(long id, String newStatus) {
        Optional<BarterRequest> optionalRequest = Optional.ofNullable(barterRequestRepository.findById(id));
        if (optionalRequest.isPresent()) {
            BarterRequest request = optionalRequest.get();
            request.setStatus(newStatus);
            return barterRequestRepository.save(request);
        }
        return null;
    }

    public void deleteBarterRequest(long id) {
        barterRequestRepository.deleteById(id);
    }
}