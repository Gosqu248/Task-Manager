package pl.gosqu.taskmanager.request;


import jakarta.validation.constraints.NotNull;

public record TaskRequest(
        @NotNull(message = "Name is required")
        String title,
        @NotNull(message = "Description is required")
        String description
) {
}
