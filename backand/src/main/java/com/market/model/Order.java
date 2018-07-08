package com.market.model;

import com.market.model.enums.OrderStatus;
import com.market.model.user.User;
import com.market.util.EntityIdentify;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.actuate.audit.listener.AuditListener;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditListener.class)
public class Order  extends EntityIdentify {


	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@CreatedDate
	private LocalDateTime createDate;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

}
