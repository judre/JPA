/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.AOrder;
import entity.Customer;
import entity.OrderLine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import javax.persistence.Query;
/**
 *
 * @author andre
 */
public class MyFacade {
    
    EntityManagerFactory emf;
  
    
    
    public MyFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public Customer CreateCustomer(Customer customer){
          EntityManager manager = getEntityManager();
         
        try{
            manager.getTransaction().begin();

            manager.persist(customer);

            manager.getTransaction().commit();
        } finally
        {
            manager.close();
        }
        return customer;
    }
    
    public Customer FindCustomer(Long id){
          EntityManager manager = getEntityManager();
        try{
            Customer customer = manager.find(Customer.class, id);
            return customer;
        }finally{
            manager.close();
            
        }
        
        
    }
    public List<Customer> GetAllCustomers(){
        EntityManager manager = getEntityManager();

        Query q = manager.createQuery("select customer from Customer customer");
        List<Customer> ListofCustomers = q.getResultList();
        return ListofCustomers;
    }
    
    public AOrder createOrder(AOrder aOrder){
        
        EntityManager manager = getEntityManager();
        try{
            manager.getTransaction().begin();

            manager.persist(aOrder);

            manager.getTransaction().commit();
        } finally
        {
            manager.close();
        }
        return aOrder;
        
    }
    
    public AOrder findOrder(Long id){
        EntityManager manager = getEntityManager();
        
        try{
            AOrder aorder = manager.find(AOrder.class, id);
            return aorder;
        }finally{
            manager.close();
        }
        
        
    }
    public Customer AddOrderToCustomer(Customer customer){
        
        EntityManager manager = getEntityManager();

        try
        {
            manager.getTransaction().begin();
            Customer c = manager.find(Customer.class, customer.getId());
            AOrder aorder = new AOrder();

            if (c != null)
            {
                List<AOrder> orders = c.getOrders();
                orders.add(aorder);
                c.setOrders(orders);
                aorder.setCustomer(c);

                manager.merge(customer);
            }
            manager.getTransaction().commit();
            return c;
        } finally
        {
            manager.close();
        }
    }
    public List<AOrder> FindOrdersToCustomer(Long id){
        EntityManager manager = getEntityManager();

        Query q = manager.createQuery("select c from AOrder c where c.customer.id = :id");
        q.setParameter("id", id);
        List<AOrder> orderList = q.getResultList();
        return orderList;

    }
    
     public OrderLine createOrderLine(int quantity, AOrder aorder)
    {
        EntityManager manager = getEntityManager();
        OrderLine orderline = new OrderLine(quantity, aorder);
        try
        {
            manager.getTransaction().begin();
            
            manager.persist(orderline);

            manager.getTransaction().commit();
        } finally
        {
            manager.close();
        }
        return orderline;
    }

}
