package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution
{
    private static Map<String, String> countries = new HashMap<String, String>();



    static
    {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }


    public static class DataAdapter implements RowItem
    {
        Customer customer;
        Contact contact;

        public DataAdapter(Customer customer, Contact contact)
        {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String code=null;
            for (Map.Entry entry : countries.entrySet())
            {

                if (entry.getValue().equals(customer.getCountryName()))
                {
                    code = String.valueOf(entry.getKey());
                }
            }
            return code;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return contact.getName().substring(contact.getName().indexOf(' ') + 1);
        }

        @Override
        public String getContactLastName()
        {
            return contact.getName().substring(0, contact.getName().indexOf(','));
        }

        @Override
        public String getDialString()
        {
            String phone = contact.getPhoneNumber();
            String number =phone.replace("(","");
            number=number.replace(")","");
            number=number.replace("-","");
            return "callto://" + number;
        }
    }

    public static interface RowItem
    {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer
    {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact
    {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}