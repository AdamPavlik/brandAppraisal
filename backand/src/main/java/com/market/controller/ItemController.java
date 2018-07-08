package com.market.controller;

import com.market.dto.ItemDto;
import com.market.service.interfaces.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class ItemController {

	private ItemService itemService;

	@GetMapping("/public/item")
	public ResponseEntity<List<ItemDto>> getUser() {
		return ResponseEntity.ok(itemService.getItemsDto());
	}


}
