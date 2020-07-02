package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Coffee DTO : Object Definition for Coffee
 *
 */

/*
Table Create Query :
CREATE TABLE COFFEE_ORDER (
    SEQ NUMBER(8),
    ORDER_USERID VARCHAR2(20),
    COFFEE_NAME VARCHAR2(30),
    COFFEE_PAY NUMBER(9),
    COFFEE_SYRUP VARCHAR2(1),
    COFFEE_SIZE VARCHAR2(1),
    COFFEE_SHOT VARCHAR2(1),
    COFFEE_CREAM VARCHAR2(1),
    COFFEE_AMOUNT NUMBER(3)
)
 */
public class CoffeeDto implements Serializable {
    private int seq;
    private String orderId;
    private String menuName;
    private int pay;
    private String syrup;
    private String size;
    private Boolean addShot;
    private Boolean addCream;
    private int amount;

    public CoffeeDto(int seq, String orderId, String menuName, int pay, String syrup, String size, Boolean addShot, Boolean addCream, int amount) {
        this.seq = seq;
        this.orderId = orderId;
        this.menuName = menuName;
        this.pay = pay;
        this.syrup = syrup;
        this.size = size;
        this.addShot = addShot;
        this.addCream = addCream;
        this.amount = amount;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getSyrup() {
        return syrup;
    }

    public void setSyrup(String syrup) {
        this.syrup = syrup;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getAddShot() {
        return addShot;
    }

    public void setAddShot(Boolean addShot) {
        this.addShot = addShot;
    }

    public Boolean getAddCream() {
        return addCream;
    }

    public void setAddCream(Boolean addCream) {
        this.addCream = addCream;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
