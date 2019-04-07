import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Split the bill

Name        Ordered     Paid    Outstanding
Person1      45          30      15
Person2     25          30      -5
Person3        20          30      -10
Total 90 / 3 = 30

X pays Y to Z


Person1 pays 5 to Person2
Person1 pays 10 to Person3


*/

class Balance {
    
    public String payer;
    public String receiver;
    public Double amount;
    
}


public class Solution {
    public static void main(String args[] ) throws Exception {
        
        HashMap<String, Double> bills = new HashMap<String, Double>();
        bills.put("Person1", 45.00);
        bills.put("Person2", 25.00);
        bills.put("Person3", 20.00);
        
        Double media = retornaDivisaoIgual(bills);
        HashMap<String, Double> outstandings = calculaOutstanding(bills, media);
        List<Balance> lista = calculateBalances(outstandings);
        
    }
    
    private static double retornaDivisaoIgual(HashMap<String, Double> bills) {
        Double total = 0.0;
        
        for (Double value : bills.values()) {
            total += value;
        }
        
        return total / bills.size();
    }
    
    private static HashMap<String, Double> calculaOutstanding(HashMap<String, Double> bills, Double media) {
        HashMap<String, Double> outstandings = new HashMap<String, Double>();
        
        
        for (Map.Entry<String, Double> bill : bills.entrySet()) {
            Double balance = bill.getValue() - media;
            outstandings.put(bill.getKey(), balance);    
        }
        
        
        return outstandings;
    }
    
    private static List<Balance> calculateBalances(HashMap<String, Double> outstandings) {
        
        ArrayList<Balance> listBalances = new ArrayList<Balance>();
        
        for (Map.Entry<String, Double> outstanding : outstandings.entrySet()) {
            //System.out.println(outstanding.getValue());
            
            while (outstanding.getValue() > 0.0) {
                String receiver = searchReceiver(outstandings);
                
                if (receiver != null) {
                    System.out.println(receiver);
                
                    Balance balance = new Balance();
                    balance.payer = outstanding.getKey();
                    balance.receiver = receiver;
                    balance.amount = outstandings.get(receiver);
                    
                    
                    Double residual = outstanding.getValue() - balance.amount;
                    System.out.println("Residual " + residual);
                    outstanding.setValue(residual);
                    //outstandings.get(receiver) += balance.amount;
                    
                    listBalances.add(balance);    
                }   
            }
        }
        return listBalances;
    }
    
    private static String searchReceiver(HashMap<String, Double> outstandings) {
        
        for (Map.Entry<String, Double> outstanding : outstandings.entrySet()) {
            System.out.println(outstanding.getValue());
            if (outstanding.getValue() < 0.0) {
                return outstanding.getKey();
            } 
        }
        
        return null;
    }
}
