package org.example.business;

import org.example.Core.Logging.Logger;
import org.example.dataAccess.HibernateProductDao;
import org.example.dataAccess.JdbcProductDao;
import org.example.dataAccess.ProductDao;
import org.example.entities.Product;

import java.util.List;

public class ProductManager
{
    private ProductDao productDao;
    private Logger[] loggers;
    public ProductManager(ProductDao productDao, Logger[] loggers)
    {
        this.productDao = productDao;
        this.loggers = loggers;
    }
    public void add(Product product) throws Exception {
        if (product.getPrice() < 10)
        {
            throw new Exception("Urun fiyati 10 dan kucuk olamaz"); //hata durumunda program durur.
        }
        productDao.add(product);
        for (Logger logger: loggers)//[db, mail, file]
        {
            logger.log(product.getName());
        }
    }
}
