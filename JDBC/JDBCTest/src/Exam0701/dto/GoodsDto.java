package Exam0701.dto;

import java.io.Serializable;
import java.util.Date;

/*
Table Create Query :
CREATE TABLE ACCOUNTBOOK (
    SEQ NUMBER(8),
    ID VARCHAR2(30),
    IO_KIND VARCHAR2(1),
    AMOUNT NUMBER(9),
    CONTENT VARCHAR2(200),
    WDATE DATE
)
 */

public class GoodsDto implements Serializable {
    private int seq;
    private String id;
    private String io_kind;
    private int amount;
    private String content;
    private Date wdate;

    public GoodsDto(int seq, String id, String io_kind, int amount, String content, Date wdate) {
        this.seq = seq;
        this.id = id;
        this.io_kind = io_kind;
        this.amount = amount;
        this.content = content;
        this.wdate = wdate;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIo_kind() {
        return io_kind;
    }

    public void setIo_kind(String io_kind) {
        this.io_kind = io_kind;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getWdate() {
        return wdate;
    }

    public void setWdate(Date wdate) {
        this.wdate = wdate;
    }
}
