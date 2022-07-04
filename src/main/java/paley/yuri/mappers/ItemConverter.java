package paley.yuri.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import paley.yuri.dto.ItemDto;
import paley.yuri.dto.request.ItemRequest;
import paley.yuri.entity.Item;
import paley.yuri.util.Constraints;

import java.math.BigDecimal;

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

  public Item fromDto(ItemDto itemDto) {
    return Item.builder()
        .name(itemDto.getName())
        .image(itemDto.getImage())
        .price(BigDecimal.valueOf(Double.parseDouble(itemDto.getPrice())))
        .build();
  }

  public void updateEntityFromDto(ItemRequest request, Item entity) {
    if (request == null) return;
    if (entity == null) return;
    entity.setName(request.getName());
    entity.setImage(request.getImage());
    entity.setPrice(BigDecimal.valueOf(Double.parseDouble(request.getPrice())));
  }
}
