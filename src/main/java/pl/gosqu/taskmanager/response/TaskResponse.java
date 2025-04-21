package pl.gosqu.taskmanager.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        Boolean completed,
        @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss:SSSSSSSSS") LocalDateTime createdAt
) {
}
