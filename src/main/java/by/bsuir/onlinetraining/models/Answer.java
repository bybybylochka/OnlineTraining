package by.bsuir.onlinetraining.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_unit_id")
    private CourseUnit courseUnit;
    @OneToOne
    private Student student;
    private String link;
    private int mark;
    private String feedback;
    private LocalDate createdAt;
}
