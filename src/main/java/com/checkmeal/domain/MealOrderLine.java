package com.checkmeal.domain;

import com.checkmeal.util.OrderLineStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MealOrderLine {

    @Id @GeneratedValue
	@Getter
	@Setter
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	@Getter
	@Setter
	private MealOrder order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Column
	@Getter
	@Setter
	private Integer qty;

    @Column
	@Getter
	@Setter
	private Double productPrice;

	@Column
	@Getter
	@Setter
	private Date registeredDate;

	@Column
	@Getter
	@Setter
	private Date lastUpdateDate;

	@Column
	@Getter
	@Setter
	private OrderLineStatus status;

	public MealOrderLine(){}

	public MealOrderLine(MealOrder order, Product product, Integer qty, OrderLineStatus orderStatus, Double productPrice, Date registeredDate, Date lastUpdateDate) {
		this.order = order;
		this.product = product;
		this.qty = qty;
		this.status = orderStatus;
		this.productPrice = productPrice;
		this.registeredDate = registeredDate;
		this.lastUpdateDate = lastUpdateDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
