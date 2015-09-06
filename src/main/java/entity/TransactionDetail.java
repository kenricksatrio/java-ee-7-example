package entity;

import listener.TimestampEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(TimestampEntityListener.class)
public class TransactionDetail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Product product;

}
