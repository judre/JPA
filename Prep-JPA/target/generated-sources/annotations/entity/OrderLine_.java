package entity;

import entity.AOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-08T19:56:05")
@StaticMetamodel(OrderLine.class)
public class OrderLine_ { 

    public static volatile SingularAttribute<OrderLine, Integer> quantity;
    public static volatile SingularAttribute<OrderLine, AOrder> aOrder;
    public static volatile SingularAttribute<OrderLine, Long> id;

}