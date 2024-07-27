package org.example.matricula.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class EnrollmentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEnrollmentDetail;

    @ManyToOne //FK
    @JoinColumn(name = "id_course", nullable = false, foreignKey = @ForeignKey(name = "FK_DETAIL_COURSE"))
    private Course course;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private double note;

    @Column(length = 5, nullable = false)
    private String classroom;
}
