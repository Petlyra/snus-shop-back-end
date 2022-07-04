package paley.yuri.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import paley.yuri.dto.ItemDto;
import paley.yuri.dto.request.ItemRequest;
import paley.yuri.entity.Item;
import paley.yuri.exception.NotFoundException;
import paley.yuri.mappers.ItemConverter;
import paley.yuri.repository.ItemsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemsService {

  private final ItemsRepository itemsRepository;
  private final ItemConverter itemConverter;

  public Item findByIdOrThrow(Long id) {
    return itemsRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Can't find item with id %s", id));
  }

  public List<ItemDto> getAll() {
    return itemsRepository.findAll().stream()
        .map(itemConverter::toDto)
        .collect(Collectors.toList());
  }

  public ItemDto save(ItemDto itemDto) {
    Item item = itemConverter.fromDto(itemDto);
    Item savedItem = itemsRepository.save(item);
    return itemConverter.toDto(savedItem);
  }

  public ItemDto update(ItemRequest itemRequest, Long id) {
    Item item = findByIdOrThrow(id);
    itemConverter.updateEntityFromDto(itemRequest, item);
    Item updatedItem = itemsRepository.save(item);
    return itemConverter.toDto(updatedItem);
  }

  public void delete(Long id) {
    Item item = findByIdOrThrow(id);
    itemsRepository.delete(item);
  }
}
