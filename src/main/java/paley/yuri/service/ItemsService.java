package paley.yuri.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import paley.yuri.dto.ItemDto;
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

  public List<ItemDto> getAll() {
    return itemsRepository.findAll().stream()
        .map(itemConverter::toDto)
        .collect(Collectors.toList());
  }
}
