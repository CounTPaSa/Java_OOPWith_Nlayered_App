package org.example.dataAccess;

import org.example.entities.Product;

public class JdbcProductDao implements ProductDao//DataAccessObject = Dao
{
    public void add(Product product)
            //Sadece DataBase erisim kodlari yazilir -> SQL bilmek gerekir
    {
        System.out.println("JDBC ile veri tabanina eklendi");
    }
}
