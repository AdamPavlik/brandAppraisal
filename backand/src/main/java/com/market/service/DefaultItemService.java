package com.market.service;

import com.google.common.collect.Lists;
import com.market.dto.ItemDto;
import com.market.model.Item;
import com.market.repository.ItemRepository;
import com.market.service.interfaces.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DefaultItemService implements ItemService {

	private ItemRepository itemRepository;

	@Override
	public List<Item> getItems() {
		return Lists.newArrayList(itemRepository.findAll());
	}

	@Override
	public List<ItemDto> getItemsDto() {
		return getItems().stream().map(ItemDto::new).collect(Collectors.toList());
	}

}
