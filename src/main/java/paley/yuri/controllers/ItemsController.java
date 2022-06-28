package paley.yuri.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import paley.yuri.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import paley.yuri.service.ItemsService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(("/api/items"))
public class ItemsController {
  private final ItemsService itemsService;

  @GetMapping("/")
  public List<ItemDto> getAllItems() {
    return itemsService.getAll();
  }
}
