package paley.yuri.dto.request;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
@Builder
public class ItemRequest {
  private String name;
  private String price;
  private String image;
}
