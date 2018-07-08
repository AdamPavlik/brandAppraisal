package com.market.model.category;

import com.market.model.Item;
import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "SUB_CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory extends EntityIdentify {

	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	private Category category;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subCategory")
	private List<Item> items;

}
