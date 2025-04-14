package io.github.surajto.skillhubbartersystemteamfusion.repository;

import io.github.surajto.skillhubbartersystemteamfusion.model.BarterRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarterRequestRepository extends JpaRepository<BarterRequest, Long> {

    List<BarterRequest> findBySenderId(long senderId);

    List<BarterRequest> findByReceiverId(long receiverId);

    BarterRequest findById(long id);
}
