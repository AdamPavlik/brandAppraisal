package com.market.model.category;

import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends EntityIdentify{

	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	private List<SubCategory> subCategories;

}
