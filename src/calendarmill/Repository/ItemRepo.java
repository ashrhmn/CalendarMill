/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Repository;

import calendarmill.Entity.Item;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashrh
 */
public class ItemRepo {

    DBConnection dbc;

    public ItemRepo() {
        dbc = new DBConnection();
    }

    public ArrayList<Item> getItems() {
        dbc.openConnection();
        ArrayList<Item> items = new ArrayList<>();
        Item item;
        try {
            dbc.result = dbc.st.executeQuery("select name,rate,(rate/0.9144) ratem from items");
            while (dbc.result.next()) {
                item = new Item();
                item.setName(dbc.result.getString("name"));
                item.setRatey(dbc.result.getDouble("rate"));
//                double d = dbc.result.getDouble("ratem")*100;
//                int i = (int) d;
//                d = i/100;
                item.setRatem(dbc.result.getDouble("ratem"));
                //item.setRatem(d);
                items.add(item);
            }
            dbc.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ItemRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
        }
        return items;
    }

    public boolean itemExists(String name) {
        dbc.openConnection();
        try {
            dbc.result = dbc.st.executeQuery("select * from items");
            if (dbc.result.next()) {
                dbc.closeConnection();
                return true;
            } else {
                dbc.closeConnection();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemRepo.class.getName()).log(Level.SEVERE, null, ex);
            dbc.closeConnection();
            return false;
        }
    }

    public void replaceItem(Item item) {

        dbc.openConnection();
        try {
            dbc.st.executeUpdate("replace into items values('" + item.getName() + "'," + item.getRatey() + ")");
        } catch (SQLException ex) {
            Logger.getLogger(ItemRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

        dbc.closeConnection();
    }

    public void deleteItem(String name) {
        dbc.openConnection();
        try {
            dbc.st.executeUpdate("delete from items where name='" + name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(ItemRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
    }
}
