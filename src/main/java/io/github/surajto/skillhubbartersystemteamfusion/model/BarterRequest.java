package io.github.surajto.skillhubbartersystemteamfusion.model;

import jakarta.persistence.*;

@Entity
@Table(name = "barter")
public class BarterRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Unique foreign key for sender
     */
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Student sender;

    /**
     * Unique foreign key for receiver
     */
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Student receiver;

    /**
     *  Unique foreign key for skill
     */
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skills skill;

    private String status;

    private String message;


}
