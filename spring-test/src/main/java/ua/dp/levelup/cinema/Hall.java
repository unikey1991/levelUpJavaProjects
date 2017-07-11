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
    private File seatsAndRanges;




    public Hall(int[][] seatsAndRanges) {
        File file = new File("seatsAndRanges.json");
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Gson gson = new Gson();
            String s = gson.toJson(Arrays.asList(seatsAndRanges));
            System.out.println(s);
            randomAccessFile.write(s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.seatsAndRanges = file;
    }

    public String getSeatsAndRangesAsJson() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(seatsAndRanges,"RW");
        return randomAccessFile.readLine();
    }

    /*@Column
    private int[] Seats;
    @Column
    private int[] Ranges;*/


}
