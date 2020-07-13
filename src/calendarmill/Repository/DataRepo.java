/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendarmill.Repository;

import calendarmill.Entity.DataItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ashrh
 */
public class DataRepo {

    DBConnection dbc;
    ArrayList<DataItem> dataItems;

    public DataRepo() {
        dbc = new DBConnection();
        dataItems = new ArrayList<>();
    }

    public String dateDecode(String date) {
        StringBuffer str = new StringBuffer(date);
        str.insert(4, '/');
        str.insert(7, '/');
        return str.toString();
    }

    public String dateEncode(String date) {
        return date.substring(0, 4) + date.substring(5, 7) + date.substring(8, 10);
    }

    public ArrayList<DataItem> getDataByCustomer(String phone) {
        dataItems.clear();
        dbc.openConnection();
        DataItem dataItem;
        try {
            dbc.result = dbc.st.executeQuery("select *,(rate*amount) 'taka' from data where phone='" + phone + "' order by date,type,item asc");
            Double balance = 0.0;
            while (dbc.result.next()) {
                dataItem = new DataItem();
                dataItem.setDate(dateDecode(dbc.result.getString("date")));
                dataItem.setName(dbc.result.getString("item"));
                dataItem.setAmount(dbc.result.getDouble("amount"));
                dataItem.setRate(dbc.result.getDouble("rate"));
                dataItem.setTaka(dbc.result.getDouble("taka"));
                dataItem.setName(dbc.result.getString("item"));
                dataItem.setType(dbc.result.getInt("type"));
                if (dbc.result.getInt("type") == 1) {
                    //payment
                    balance -= dbc.result.getDouble("taka");
                } else {
                    //purchase
                    balance += dbc.result.getDouble("taka");
                }
                dataItem.setPayable(balance);
                dataItems.add(dataItem);
                dataItem = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataRepo.class.getName()).log(Level.SEVERE, null, ex);
        }
        dbc.closeConnection();
        return dataItems;
    }
}
