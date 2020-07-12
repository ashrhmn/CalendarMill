/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Repository;

import calendarmill.Entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashrh
 */
public class CustomerRepo {

    DBConnection dbc;

    public CustomerRepo() {
        dbc = new DBConnection();
    }

    public Customer getCustomer(String phone) {
        Customer customer = null;
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from customer where phone='" + phone + "'");
            if (dbc.result.next()) {
                customer = new Customer();
                customer.setName(dbc.result.getString("name"));
                customer.setAddress(dbc.result.getString("address"));
                customer.setPhone(dbc.result.getString("phone"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }

    public boolean addCustomer(Customer customer) {
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("insert into customer values('" + customer.getName() + "','" + customer.getAddress() + "','" + customer.getPhone() + "')");
            dbc.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }

    public boolean replaceCustomer(Customer customer) {
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into customer values('" + customer.getName() + "','" + customer.getAddress() + "','" + customer.getPhone() + "')");
            dbc.closeConnection();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }

    public void deleteCustomer(String phone) {
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("delete from customer where phone='" + phone + "'");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean customerExists(String phone) {
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from customer where phone='" + phone + "'");
            if(dbc.result.next()){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean customerExists(Customer customer){
        return customerExists(customer.getPhone());
    }

    public void deleteCustomer(Customer customer) {
        deleteCustomer(customer.getPhone());
    }

    public ArrayList<Customer> getCustomerFilteredByName(String name) {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from customer where name like '%" + name + "%' order by name asc");
            while (dbc.result.next()) {
                customer = new Customer();
                customer.setName(dbc.result.getString("name"));
                customer.setAddress(dbc.result.getString("address"));
                customer.setPhone(dbc.result.getString("phone"));
                customers.add(customer);
                customer = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return customers;
    }

    public ArrayList<Customer> getCustomerFilteredByPhone(String phone) {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from customer where phone like '%" + phone + "%' order by name asc");
            while (dbc.result.next()) {
                customer = new Customer();
                customer.setName(dbc.result.getString("name"));
                customer.setAddress(dbc.result.getString("address"));
                customer.setPhone(dbc.result.getString("phone"));
                customers.add(customer);
                customer = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return customers;
    }
}
