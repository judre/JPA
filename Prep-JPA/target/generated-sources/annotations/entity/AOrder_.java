package entity;

import entity.Customer;
import entity.OrderLine;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-08T19:56:05")
@StaticMetamodel(AOrder.class)
public class AOrder_ { 

    public static volatile ListAttribute<AOrder, OrderLine> orderlines;
    public static volatile SingularAttribute<AOrder, Long> id;
    public static volatile SingularAttribute<AOrder, Customer> customer;

}