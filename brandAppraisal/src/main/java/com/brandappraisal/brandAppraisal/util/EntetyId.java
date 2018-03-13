package com.brandappraisal.brandAppraisal.util;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
public class EntetyId {
	@Id
	@GeneratedValue
	private long id;
}
