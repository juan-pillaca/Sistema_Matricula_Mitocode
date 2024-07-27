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
public class ShiftDTO {

    private Integer idShift;

    @NotNull
    @Size(min = 3, max = 30)
    private String nameShift;

    @NotNull
    @Size(min = 3, max = 60)
    private String descriptionShift;

    @NotNull
    private boolean enabledShift;
}
