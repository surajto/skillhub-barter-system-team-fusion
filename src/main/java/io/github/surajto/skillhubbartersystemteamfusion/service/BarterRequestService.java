package io.github.surajto.skillhubbartersystemteamfusion.service;

import io.github.surajto.skillhubbartersystemteamfusion.model.BarterRequest;

import java.util.List;

public interface BarterRequestService {

    BarterRequest createBarterRequest(BarterRequest barterRequest);
    List<BarterRequest> getAllRequests();
    List<BarterRequest> getRequestsBySender(long senderId);
    List<BarterRequest> getRequestsByReceiver(long receiverId);
    BarterRequest updateStatus(long id, String status);
    void deleteBarterRequest(long id);
}