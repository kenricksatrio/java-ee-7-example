package entity;

import listener.TimestampEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@EntityListeners(TimestampEntityListener.class)
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(TemporalType.TIME)
    private Date transactionDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
