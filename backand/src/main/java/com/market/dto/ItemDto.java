package com.market.dto;

import com.market.model.Item;
import com.market.model.enums.Color;
import com.market.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	public ItemDto(Item item){
		ItemDto dto = new ItemDto();
		dto.setId(item.getId());
		dto.setName(item.getName());
		dto.setGroupName(item.getGroupName());
		dto.setDescription(item.getDescription());
		dto.setPrice(item.getPrice());
		dto.setCurrency(item.getCurrency());
		dto.setDiscount(item.getDiscount());
		dto.setSubCategory(item.getSubCategory().getName());
		dto.setSubCategoryId(item.getSubCategory().getId());
		dto.setCategory(item.getSubCategory().getCategory().getName());
		dto.setCategoryId(item.getSubCategory().getCategory().getId());
		dto.setColor(item.getColor());
		dto.setWeight(item.getWeight());
	}

	private Long id;

	private String name;

	private String groupName;

	private String description;

	private Double price;

	private Currency currency;

	private Double discount;

	private String subCategory;

	private Long subCategoryId;

	private String category;

	private Long categoryId;

	private Color color;

	private Double weight;
}
