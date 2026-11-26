package prodcons;

import java.io.IOException;
import java.util.Properties;

public class TestProdCons {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.loadFromXML(
        TestProdCons.class.getClassLoader().getResourceAsStream("options.xml"));
        int nProd = Integer.parseInt(properties.getProperty("nProd"));
        int nCons = Integer.parseInt(properties.getProperty("nCons"));
        
    }
}