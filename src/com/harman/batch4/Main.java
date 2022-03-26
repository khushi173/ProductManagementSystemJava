package com.harman.batch4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choices;
        while (true) {
            System.out.println(" 1.Add The Products ");
            System.out.println(" 2. View all Products ");
            System.out.println(" 3. Search a Product Using Product Code ");
            System.out.println(" 4. Update Product Details Using Product Code ");
            System.out.println(" 5. Delete A Product Using Product Code ");
            System.out.println(" 6. Display All The Details Of The Product Whose Price Is Greater Than 50000");
            System.out.println(" 7. Display The Count Of Total Number Of Products In The Company");
            System.out.println(" 8.Display All The Product Details In Alphabetic Order");
            System.out.println(" EXIT");
            System.out.println(" SELECT AN OPTION ");
            choices = input.nextInt();
            switch (choices) {
                case 1:
                    String ProductCode, ProductName, Brand, Price, Model, YearOfManufacturing, ExpiryYear;
                    System.out.println(" ENTER PRODUCT CODE: ");
                    ProductCode = input.next();
                    System.out.println(" ENTER PRODUCT NAME: ");
                    ProductName = input.next();
                    System.out.println(" ENTER BRAND: ");
                    Brand = input.next();
                    System.out.println(" ENTER PRICE OF PRODUCT: ");
                    Price = input.next();
                    System.out.println(" ENTER MODEL: ");
                    Model = input.next();
                    System.out.println(" ENTER YEAR OF MANUFACTURING: ");
                    YearOfManufacturing = input.next();
                    System.out.println(" ENTER EXPIRY YEAR: ");
                    ExpiryYear = input.next();
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `productdetails`(`ProductCode`, `ProductName`, `Brand`, `Price`, `Model`, `YearOfManufacturing`, `ExpiryYear`) VALUES (" + ProductCode + ",'" + ProductName + "','" + Brand + "'," + Price + ",'" + Model + "'," + YearOfManufacturing + ","+ExpiryYear+")");
                        System.out.println("INSERTED SUCESSFULLY");

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `ProductCode`, `ProductName`, `Brand`, `Price`, `Model`, `YearOfManufacturing`, `ExpiryYear` FROM `productdetails` WHERE 1");
                        while (rs.next()) {
                            System.out.println(" ProductCode: " + rs.getString("ProductCode"));
                            System.out.println(" ProductName: " + rs.getString("ProductName"));
                            System.out.println(" Brand: " + rs.getString("Brand"));
                            System.out.println(" Price: " + rs.getString("Price"));
                            System.out.println(" Model: " + rs.getString("Model"));
                            System.out.println(" YearOfManufacturing: " + rs.getString("YearOfManufacturing"));
                            System.out.println(" ExpiryYear: " + rs.getString("ExpiryYear"));
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        int productcode;
                        System.out.println("Enter the product code to be searched");
                        productcode = input.nextInt();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `productdetails` WHERE `ProductCode` = "+productcode);
                        while (rs.next()) {
                            System.out.println(" ProductName: " + rs.getString("ProductName"));
                            System.out.println(" Brand: " + rs.getString("Brand"));
                            System.out.println(" Price: " + rs.getString("Price"));
                            System.out.println(" Model: " + rs.getString("Model"));
                            System.out.println(" YearOfManufacturing: " + rs.getString("YearOfManufacturing"));
                            System.out.println(" ExpiryYear: " + rs.getString("ExpiryYear"));
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        int productcode;
                        System.out.println("Enter the product code to be updated");
                        productcode = input.nextInt();
                        stmt.executeUpdate("UPDATE `productdetails` SET `ProductName`= 'Phone' WHERE `ProductCode` = "+productcode);
                        System.out.println("UPDATED");

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        int productcode;
                        System.out.println("Enter the ProductCode of Product to be deleted: ");
                        productcode = input.nextInt();
                        stmt.executeUpdate("DELETE FROM `productdetails` WHERE `ProductCode`="+productcode);
                        System.out.println("PRODUCT DELETED");
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `productdetails` WHERE `Price` >50000");
                        while (rs.next()) {
                            System.out.println(" ProductName: " + rs.getString("ProductName"));
                            System.out.println(" Brand: " + rs.getString("Brand"));
                            System.out.println(" Price: " + rs.getString("Price"));
                            System.out.println(" Model: " + rs.getString("Model"));
                            System.out.println(" YearOfManufacturing: " + rs.getString("YearOfManufacturing"));
                            System.out.println(" ExpiryYear: " + rs.getString("ExpiryYear"));
                        }

                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 7:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT COUNT(*)  FROM `productdetails`");
                        rs.next();
                        int count = rs.getInt(1);
                        System.out.println("Number of records in productDetails table are: "+count);
                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;
                case 8:
                    try{
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abcdcompany?autoReconnect=true&useSSL=false", "root", "");
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT * FROM `productdetails` ORDER BY `ProductName` ASC ");
                        while (rs.next()) {
                            System.out.println(" ProductName: " + rs.getString("ProductName"));
                            System.out.println(" Brand: " + rs.getString("Brand"));
                            System.out.println(" Price: " + rs.getString("Price"));
                            System.out.println(" Model: " + rs.getString("Model"));
                            System.out.println(" YearOfManufacturing: " + rs.getString("YearOfManufacturing"));
                            System.out.println(" ExpiryYear: " + rs.getString("ExpiryYear"));
                        }


                    }
                    catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                default:
                    System.out.println("INVALID CHOICE");
            }
        }
    }
}




