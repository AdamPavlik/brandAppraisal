package com.brandappraisal.brandAppraisal.util;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class EntityIdentify {

	@Id
	@GeneratedValue
	private long id;
}
