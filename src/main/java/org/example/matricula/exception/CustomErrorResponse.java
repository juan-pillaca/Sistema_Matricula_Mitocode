package org.example.matricula.exception;

import java.time.LocalDate;

public record CustomErrorResponse(
        LocalDate dateTime,
        String message,
        String path
) {
}
