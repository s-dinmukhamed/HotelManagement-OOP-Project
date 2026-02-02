import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import database.ClothingitemDAO;
import menu.Menu;
import menu.clothingStoreMenu;
import database.DatabaseConnection;
import model.clothingitem;

public class Main{
    public static void main(String[] args) {
        Menu menu = new clothingStoreMenu();
        menu.run();
    }
}