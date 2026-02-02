package database;

import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClothingitemDAO {
    public void insertItem(clothingitem clothingitem) {
        String sql = "INSERT INTO clothingitem (item_id, size, price, brand, amount, cloth_type, material, fabric_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, clothingitem.getId());
            statement.setString(2, clothingitem.getSize());
            statement.setDouble(3, clothingitem.getPrice());
            statement.setString(4, clothingitem.getBrand());
            statement.setInt(5, clothingitem.getAmount());
            statement.setString(6, clothingitem.getClothType());
            statement.setString(7, clothingitem.getMaterial());
            statement.setString(8, clothingitem.getFabricType());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Item inserted successfully!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Insert failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public static boolean insertShirt(Shirt shirt) {
        String sql = "INSERT INTO clothingitem (item_id, size, price, brand, amount, material, cloth_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, 'Shirt')";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, shirt.getId());
            statement.setString(2, shirt.getSize());
            statement.setDouble(3, shirt.getPrice());
            statement.setString(4, shirt.getBrand());
            statement.setInt(5, shirt.getAmount());
            statement.setString(6, shirt.getMaterial());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Shirt inserted: " + shirt.getBrand() + " (" + shirt.getSize() + ")");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Shirt failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public static boolean insertPants(Pants pants) {
        String sql = "INSERT INTO clothingitem (item_id, size, price, brand, amount, fabric_type, cloth_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, 'Pants')";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pants.getId());
            statement.setString(2, pants.getSize());
            statement.setDouble(3, pants.getPrice());
            statement.setString(4, pants.getBrand());
            statement.setInt(5, pants.getAmount());
            statement.setString(6, pants.getFabricType());

            int rowsInserted = statement.executeUpdate();
            statement.close();

            if (rowsInserted > 0) {
                System.out.println("✅ Pants inserted: " + pants.getBrand() + " (" + pants.getSize() + ")");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Insert Pants failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public static boolean updateShirts(Shirt Shirt) {
        String sql = "UPDATE clothingitem SET size = ?, amount = ?, price = ?, brand = ?, material = ? " +
                "WHERE item_id = ? AND cloth_type = 'Shirt'";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, Shirt.getSize());
            statement.setInt(3, Shirt.getAmount());
            statement.setDouble(4, Shirt.getPrice());
            statement.setString(5, Shirt.getBrand());
            statement.setString(7, Shirt.getMaterial());
            statement.setInt(1, Shirt.getId());
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("Shirt updated: " + Shirt.getBrand());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    public static List<clothingitem> getAllItems() {
        String sql = "SELECT * FROM clothingitem";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("\n--- ALL ITEMS FROM DATABASE ---");
            while (resultSet.next()) {
                int id = resultSet.getInt("item_id");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                String brand = resultSet.getString("brand");
                int amount = resultSet.getInt("amount");
                String cloth_type = resultSet.getString("cloth_type");
                String material = resultSet.getString("material");
                String fabric_type = resultSet.getString("fabric_type");

                System.out.println("ID: " + id);
                System.out.println("Size: " + size);
                System.out.println("Price: " + price);
                System.out.println("Brand: " + brand);
                System.out.println("Amount: " + amount);
                System.out.println("Cloth Type: " + cloth_type);
                System.out.println("Material: " + material);
                System.out.println("Fabric Type: " + fabric_type);
                System.out.println("---");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }

    public static boolean updatePants(Pants pants) {

        String sql = "UPDATE clothingitem SET size = ?, amount = ?, price = ?, brand = ?, fabric_type = ? " +
                "WHERE item_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);


            statement.setString(2, pants.getSize());
            statement.setInt(3, pants.getAmount());
            statement.setDouble(4, pants.getPrice());
            statement.setString(5, pants.getBrand());
            statement.setString(6, pants.getFabricType());
            statement.setInt(1, pants.getId());


            int rowsUpdated = statement.executeUpdate();
            statement.close();

            if (rowsUpdated > 0) {
                System.out.println("✅ Pants updated: " + pants.getBrand());
                return true;
            }

        } catch (SQLException e) {
            System.out.println("❌ Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }


    public static void displayAllItems() {
        List<clothingitem> itemsList = getAllItems();

        System.out.println("\n========================================");
        System.out.println("   ALL ITEMS FROM DATABASE");
        System.out.println("========================================");

        if (itemsList.isEmpty()) {
            System.out.println("No items in the database.");
        } else {
            for (int i = 0; i < itemsList.size(); i++) {
                clothingitem item = itemsList.get(i);
                System.out.print((i + 1) + ". ");


                if (item instanceof Shirt) {
                    Shirt shirt = (Shirt) item;
                    System.out.println("[" + shirt.getBrand() + "] " + shirt.toString());
                    System.out.println("   Material: " + shirt.getMaterial());
                    if (shirt.isAffordable()) {
                        System.out.println("   ⭐ AFFORDABLE (Price < 20,000 KZT)");
                    }
                } else if (item instanceof Pants) {
                    Pants pants = (Pants) item;
                    System.out.println("[" + pants.getBrand() + "] " + pants.toString());
                    System.out.println("   Fabric Type: " + pants.getFabricType());
                }
            }
        }

        System.out.println("========================================\n");

    }

    public static List<Shirt> getAllShirts() {
        List<Shirt> shirts = new ArrayList<>();
        String sql = "SELECT * FROM clothingitem WHERE cloth_type = 'Shirt' ORDER BY item_id";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return shirts;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);
                if (item instanceof Shirt) {
                    shirts.add((Shirt) item);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + shirts.size() + " shirts from database");

        } catch (SQLException e) {
            System.out.println("❌ Select shirts failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return shirts;
    }//finished

    public static List<Pants> getAllPants() {
        List<Pants> pantsList = new ArrayList<>();
        String sql = "SELECT * FROM clothingitem WHERE cloth_type = 'Pants' ORDER BY item_id";  // Извлекаем только брюки

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return pantsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);  // Используем метод для извлечения объекта из результата
                if (item instanceof Pants) {  // Проверяем, если это Pants
                    pantsList.add((Pants) item);  // Добавляем Pants в список
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + pantsList.size() + " pants from database");

        } catch (SQLException e) {
            System.out.println("❌ Select pants failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return pantsList;
    }//finished


    private static clothingitem extractItemFromResultSet(ResultSet resultSet) throws SQLException {
        int itemId = resultSet.getInt("item_id");
        String size = resultSet.getString("size");
        double price = resultSet.getDouble("price");
        String brand = resultSet.getString("brand");
        int amount = resultSet.getInt("amount");
        String clothType = resultSet.getString("cloth_type");
        String material = resultSet.getString("material");
        String fabricType = resultSet.getString("fabric_type");

        if ("Shirt".equalsIgnoreCase(clothType)) {
            return new Shirt(itemId, size, price, brand, amount, material, clothType);
        } else if ("Pants".equalsIgnoreCase(clothType)) {
            return new Pants(itemId, size, price, brand, amount, fabricType, clothType);
        }

        return null;
    }

    public List<clothingitem> searchByBrand(String brand) {
        List<clothingitem> itemsList = new ArrayList<>();

        String sql = "SELECT * FROM clothingitem WHERE brand ILIKE ? ORDER BY brand";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return itemsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + brand + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);
                if (item != null) {
                    itemsList.add(item);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + itemsList.size() + " items matching brand '" + brand + "'");

        } catch (SQLException e) {
            System.out.println("❌ Search by brand failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return itemsList;
    }

    public List<clothingitem> searchByPriceRange(double minPrice, double maxPrice) {
        List<clothingitem> itemsList = new ArrayList<>();

        String sql = "SELECT * FROM clothingitem WHERE price BETWEEN ? AND ? ORDER BY price DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return itemsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);
                if (item != null) {
                    itemsList.add(item);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + itemsList.size() + " items in price range " + minPrice + " - " + maxPrice);

        } catch (SQLException e) {
            System.out.println("❌ Search by price failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return itemsList;
    }

    public List<clothingitem> searchByMinPrice(double minPrice) {
        List<clothingitem> itemsList = new ArrayList<>();

        String sql = "SELECT * FROM clothingitem WHERE price >= ? ORDER BY price DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return itemsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);
                if (item != null) {
                    itemsList.add(item);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Found " + itemsList.size() + " items with price >= " + minPrice);

        } catch (SQLException e) {
            System.out.println("❌ Search by min price failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return itemsList;
    }

    public static void demonstratePolymorphism() {
        List<clothingitem> itemsList = ClothingitemDAO.getAllItems();
        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Items from Database");
        System.out.println("========================================");

        if (itemsList.isEmpty()) {
            System.out.println("No items to demonstrate.");
        } else {
            for (clothingitem item : itemsList) {
                item.MadeOf();
            }
        }

        System.out.println("========================================\n");
    }

    public boolean deleteItem(int itemId) {
        String sql = "DELETE FROM clothingitem WHERE item_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            if (rowsDeleted > 0) {
                System.out.println("✅ Item deleted (ID: " + itemId + ")");
                return true;
            } else {
                System.out.println("⚠️ No item found with ID: " + itemId);
            }

        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return false;
    }

    public clothingitem getItemById(int itemId) {
        String sql = "SELECT * FROM clothingitem WHERE item_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, itemId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                clothingitem item = extractItemFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (item != null) {
                    System.out.println("✅ Found item with ID: " + itemId);
                }

                return item;
            }

            System.out.println("⚠️ No item found with ID: " + itemId);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }
}
