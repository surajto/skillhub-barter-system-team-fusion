package io.github.surajto.skillhubbartersystemteamfusion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "barter_request")
public class BarterRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private Student sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private Student receiver;

    @Column(nullable = false)
    private String status; // e.g., "Pending", "Accepted", "Rejected"

    @Column
    private String message;

    @Column(nullable = false)
    private long skill_id;

    public BarterRequest() {
    }

    public BarterRequest(Student sender, Student receiver, String status, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.status = status;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getSender() {
        return sender;
    }

    public void setSender(Student sender) {
        this.sender = sender;
    }

    public Student getReceiver() {
        return receiver;
    }

    public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}