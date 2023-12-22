package capstone.backend.dto;


import capstone.backend.domain.Category;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProfileDto {
    private String email;
    private String nickname;
    private LocalDate birth;
    private Long sex;
    private List<Category> category;


}
