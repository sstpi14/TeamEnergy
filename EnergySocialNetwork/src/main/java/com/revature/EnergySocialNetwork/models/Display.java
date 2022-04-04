package com.revature.EnergySocialNetwork.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "displays")
public class Display {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer displayId;
    @Column
    private Blob img;
    @ManyToOne
    private Profile profile;
    @OneToMany(mappedBy = "display", cascade = CascadeType.ALL) //this references the variable in the song class
    private List<Like> likes = new ArrayList<>();
    @Column
    private String description;

    public Display(Integer displayId, Integer numOfLikes, String description) {
        this.displayId = displayId;
        this.description = description;
    }
}
