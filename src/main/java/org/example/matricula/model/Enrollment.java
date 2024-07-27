package org.example.matricula.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollment; //registro o matricula

    @ManyToOne //FK
    @JoinColumn(name = "id_student", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_STUDENT"))
    private Student student;

    @ManyToOne //FK
    @JoinColumn(name = "id_shift", nullable = false, foreignKey = @ForeignKey(name = "FK_ENROLLMENT_SHIFT"))
    private Shift shift;

    @Column(nullable = false)
    private LocalDate dateTime;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_enrollment")
    private List<EnrollmentDetail> details;
}
