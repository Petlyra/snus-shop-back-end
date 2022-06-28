package paley.yuri.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@Builder
public class ItemDto {
  private String id;
  private String name;
  private String price;
  private String image;
  private String createdAt;
}
