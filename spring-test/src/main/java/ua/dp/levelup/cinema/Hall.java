package ua.dp.levelup.cinema;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.List;

/**
 * Created by unike on 10.07.2017.
 */


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "HALLS")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int seatsNumberInHall;

    @Column
    private int rowsNumberInHall;


    public Hall(int seatsNumberInHall, int rowsNumberInHall) {
        this.seatsNumberInHall = seatsNumberInHall;
        this.rowsNumberInHall = rowsNumberInHall;
    }
}
