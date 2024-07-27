package org.example.matricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private StudentDTO student;

    @NotNull
    private ShiftDTO shift;

    @NotNull
    private LocalDate dateTime;

    @NotNull
    private List<EnrollmentDetailDTO> details;
}
