package by.bsuir.onlinetraining.models;

import by.bsuir.onlinetraining.models.enums.CompletingStatus;
import by.bsuir.onlinetraining.models.enums.CourseStatus;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "purchased_courses")
public class PurchasedCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @Enumerated(EnumType.STRING)
    private CompletingStatus completingStatus;
}
