package com.market.model;

import com.market.exceptions.MarketException;
import com.market.model.category.SubCategory;
import com.market.model.enums.Color;
import com.market.model.enums.Currency;
import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ITEM")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditListener.class)
@Slf4j
public class Item extends EntityIdentify {

	@NonNull
	private String name;

	@NonNull
	private String groupName;

	@NonNull
	private String description;

	@NonNull
	private Double price;

	@Enumerated(EnumType.STRING)
	private Currency currency;

	private Double discount = 0.0;

	@ManyToOne(fetch = FetchType.LAZY)
	private SubCategory subCategory;

	@CreatedDate
	private LocalDateTime createDate;

	@OneToOne
	@JoinColumn
	private Order order;

	@Enumerated(EnumType.STRING)
	private Color color;

	private Double weight;



	private LocalDateTime expirationDate;

	public void setDiscount(Double discount) throws MarketException {
		if(price == null){
			log.warn("Can not set discount to Item:" + toString() + " because price is null");
			throw new MarketException("Pleas set discount after price");
		} else if(this.price < discount){
			log.warn("Can not set discount to Item:" + toString() + " because discount bigger than price.");
			throw new MarketException("Discount can not be bigger than price");
		} else {
			this.discount = discount;
		}
	}

	private void setPrice(Double price) throws MarketException {
		if(price < 0.0){
			log.warn("Can not set price to Item:" + toString() + " because price is lower than 0");
			throw new MarketException("Price should be bigger than 0");
		} else {
			this.price = price;
		}
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + getId() + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
