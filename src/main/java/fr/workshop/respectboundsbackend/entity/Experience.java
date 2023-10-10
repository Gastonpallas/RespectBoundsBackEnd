package fr.workshop.respectboundsbackend.entity;


import fr.workshop.respectboundsbackend.ExperienceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table
@ToString
public class Experience {
    @Id
    @SequenceGenerator(name = "name_sequence", sequenceName = "name_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_sequence")
    private Long id;
    private String text;
    private ExperienceType type;

}
