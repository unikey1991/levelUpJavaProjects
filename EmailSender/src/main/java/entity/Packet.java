package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

/**
 * Created by unike on 06.05.2017.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PACKET")
public class Packet {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_packet")
    private long id;

    @Column(name = "packet_name")
    private String packetName;

    @Column(name = "load_date")
    private Date loadDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "loaded_by_user")
    private User loadedBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_user")
    private User assignedTo;

    @Column
    private File file;

    public Packet(String packetName, Date loadDate, User loadedBy, User assignedTo, File file) {
        this.packetName = packetName;
        this.loadDate = loadDate;
        this.loadedBy = loadedBy;
        this.assignedTo = assignedTo;
        this.file = file;
    }
}
