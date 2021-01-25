package com.checkmeal.domain;

import com.checkmeal.datacreator.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
public class MealOrder {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "mealtable_id")
    @Getter
    @Setter
    private MealTable mealTable;

    @ManyToOne
    @JoinColumn(name = "waiter_id")
    @Getter
    @Setter
    private Employee waiter;

    @ManyToOne
    @JoinColumn(name = "chef_id")
    @Getter
    @Setter
    private Employee chef;

    @OneToMany(mappedBy = "product")
    private List<MealOrderLine> orderLines;

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
    private OrderStatus status;

    public MealOrder() {
    }

    public MealOrder(MealTable mealTable, Employee waiter, Employee chef, List<MealOrderLine> orderLines, Date registeredDate, Date lastUpdateDate, OrderStatus status) {
        this.mealTable = mealTable;
        this.waiter = waiter;
        this.chef = chef;
        this.orderLines = orderLines;
        this.registeredDate = registeredDate;
        this.lastUpdateDate = lastUpdateDate;
        this.status = status;
    }

    public List<MealOrderLine> getOrderLines() {
        return orderLines;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
