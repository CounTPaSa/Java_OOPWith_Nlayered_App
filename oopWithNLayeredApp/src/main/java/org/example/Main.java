package org.example;

import org.example.Core.Logging.DataBaseLogger;
import org.example.Core.Logging.FileLogger;
import org.example.Core.Logging.Logger;
import org.example.Core.Logging.MailLogger;
import org.example.business.ProductManager;
import org.example.dataAccess.HibernateProductDao;
import org.example.dataAccess.JdbcProductDao;
import org.example.entities.Product;

public class Main {
    public static void main(String[] args) throws Exception {
        Product product1 = new Product(1, "IphoneXr", 10000);
        Logger[] loggers = {new DataBaseLogger(),new FileLogger(), new MailLogger()};

        ProductManager productManager = new ProductManager(new HibernateProductDao(), loggers);
        productManager.add(product1);
    }
}