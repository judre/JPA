/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entity.AOrder;
import entity.Customer;
import facade.MyFacade;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class main {
    
    public static void main(String[] args) {
        MyFacade myfacade = new MyFacade(Persistence.createEntityManagerFactory("pu"));

        Customer customer = new Customer("Andre", "andre@email.dk");
        
        System.out.println("__________________");
        System.out.println("Create Customer: " + myfacade.CreateCustomer(customer)); // default 23
        
        System.out.println("__________________");
        long one = 1;
        System.out.println("Find Customer: " + myfacade.FindCustomer(one));
        
        System.out.println("__________________");
        System.out.println("Find All Customers" + myfacade.GetAllCustomers());
        
        AOrder aorder = new AOrder();
        aorder.setCustomer(customer);
        System.out.println("__________________");
        System.out.println("Create Order: " + myfacade.createOrder(aorder));
        
        System.out.println("__________________");
        System.out.println("Find Order:" + myfacade.findOrder(one));
        
        myfacade.AddOrderToCustomer(customer);
        
        System.out.println("__________________");
        System.out.println("Find all Orders, for a specific Customer: \n"
                + "Customer: " + 1 + "\n"+ myfacade.FindOrdersToCustomer(one));
        
        
    }
    
}
