package capstone.backend.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PostingDto {
    private String title;

    private String body;

    private String studyName;
}
