package paley.yuri.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import paley.yuri.dto.ItemDto;
import paley.yuri.entity.Item;

@Component
@RequiredArgsConstructor
public class ItemConverter {
  public ItemDto toDto(Item item) {
    return ItemDto.builder()
        .id(item.getId())
        .name(item.getName())
        .price(item.getPrice())
        .image(item.getImage())
        .build();
  }
}
