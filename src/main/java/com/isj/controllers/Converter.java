package com.isj.controllers;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class Converter {
    public Date convertStringToDate(String dateString) throws Exception {

        try {

            DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

            return (Date) df.parse(dateString);

        } catch (Exception ex) {

            throw new Exception("Error to convert String into Date: " + ex.getMessage());

        }

    }
}
