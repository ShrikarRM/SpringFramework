package com.account.loosecoupling.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "election_results")
@ToString
public class ElectionResultsDTO implements Serializable {
	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	@Column(name = "result_Id")
	private long resultId;
	@Column(name = "candidate_name")
	private String candidateName;
	@Column(name = "party_name")
	private String partyName;
	@Column(name = "ward_no")
	private int wardNo;
	@Column(name = "won_By")
	private int wonBy;

}
