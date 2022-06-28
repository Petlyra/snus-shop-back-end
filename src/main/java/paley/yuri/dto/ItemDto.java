package paley.yuri.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@Builder
public class ItemDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String image;
    private LocalDateTime createdAt;
}
