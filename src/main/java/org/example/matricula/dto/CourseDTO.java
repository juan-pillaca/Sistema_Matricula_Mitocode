package org.example.matricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    private CareerDTO career;

    @NotNull
    @Size(min = 3, max = 50)
    private String nameCourse;

    @NotNull
    @Size(min = 3, max = 100)
    private String descriptionCourse;

    @NotNull
    private boolean enabledCourse;
}
