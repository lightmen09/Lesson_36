package tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

public class JsonTest {

    private final ClassLoader cl = JsonTest.class.getClassLoader();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public static class Order {
        public String orderId;
        public Customer customer;
        public List<Item> items;
        public double total;
        public String status;
    }

    public static class Customer {
        public String id;
        public String name;
        public String email;
    }

    public static class Item {
        public String code;
        public String name;
        public int qty;
        public double price;
    }

    @DisplayName("Проверяем JSON-файл order.json")
    @Test
    void parseOrderJsonWithJackson() throws Exception {
        try (InputStream is = cl.getResourceAsStream("order.json")) {
            Assertions.assertNotNull(is, "Файл order.json не найден в resources");

            Order order = objectMapper.readValue(is, Order.class);

            Assertions.assertEquals("ORD-2025-1", order.orderId);
            Assertions.assertEquals("PAID", order.status);
            Assertions.assertEquals(588.99, order.total);

            Assertions.assertEquals("CUST-23", order.customer.id);
            Assertions.assertEquals("Mikel Jordan", order.customer.name);
            Assertions.assertEquals("jordan@example.com", order.customer.email);

            Assertions.assertEquals(2, order.items.size());
            Assertions.assertEquals("Nike-001", order.items.get(0).code);
            Assertions.assertEquals("Running Nike", order.items.get(0).name);
            Assertions.assertEquals(1, order.items.get(0).qty);
            Assertions.assertEquals(129.99, order.items.get(0).price);

            Assertions.assertEquals("Nike-002", order.items.get(1).code);
            Assertions.assertEquals("Sport Nike", order.items.get(1).name);
            Assertions.assertEquals(2, order.items.get(1).qty);
            Assertions.assertEquals(229.50, order.items.get(1).price);
        }
    }
}