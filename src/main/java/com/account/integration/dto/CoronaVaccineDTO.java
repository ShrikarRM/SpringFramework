package com.account.integration.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "corona_vaccine")
public class CoronaVaccineDTO {
	@Id
	@Column(name = "v_id")
	private long vaccineId;
	@Column(name = "v_name")
	private String name;
	@Column(name = "v_developedBy")
	private String developedBy;
	@Column(name = "v_country")
	private String country;
	@Column(name = "v_readyToUse")
	private boolean readyToUse;

}
