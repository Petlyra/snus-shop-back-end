package paley.yuri.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import paley.yuri.dto.ItemDto;
import paley.yuri.dto.request.ItemRequest;
import paley.yuri.service.ItemsService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/items/"))
public class ItemsController {
  private final ItemsService itemsService;

  @GetMapping("")
  public List<ItemDto> getAllItems() {
    return itemsService.getAll();
  }

  @PostMapping("")
  public ItemDto saveItem(ItemDto itemDto) {
    return itemsService.save(itemDto);
  }

  @PutMapping("{id}")
  public ItemDto updateItem(@RequestBody ItemRequest itemRequest, @PathVariable Long id) {
    return itemsService.update(itemRequest, id);
  }

  @DeleteMapping("{id}")
  public void deleteItem(@PathVariable Long id) {
    itemsService.delete(id);
  }
}
