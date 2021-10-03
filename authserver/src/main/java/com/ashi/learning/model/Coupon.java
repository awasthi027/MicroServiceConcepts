package com.ashi.learning.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coupon {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	private String code;
	private BigDecimal discount;
	private String exp_date;

	public Coupon() {
	
	}

	public Coupon(long id, String code, BigDecimal discount, String exp_date) {
		super();
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.exp_date = exp_date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExp_date() {
		return exp_date;
	}

	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", code=" + code + ", discount=" + discount + ", exp_date=" + exp_date + "]";
	}
	

}
