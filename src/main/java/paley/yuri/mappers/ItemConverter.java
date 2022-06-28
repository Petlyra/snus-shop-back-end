package paley.yuri.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import paley.yuri.dto.ItemDto;
import paley.yuri.entity.Item;
import paley.yuri.util.Constraints;

@Component
@RequiredArgsConstructor
public class ItemConverter {
  public ItemDto toDto(Item item) {
    return ItemDto.builder()
        .id(item.getId().toString())
        .name(item.getName())
        .price(item.getPrice().toString())
        .image(item.getImage())
        .createdAt(Constraints.formatter.format(item.getCreatedAt()))
        .build();
  }
}
