package com.market.service.interfaces;

import com.market.dto.ItemDto;
import com.market.model.Item;

import java.util.List;

public interface ItemService {

	List<Item> getItems();

	List<ItemDto> getItemsDto();

}
