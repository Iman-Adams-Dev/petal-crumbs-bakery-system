// GUI application using Swing and JFrame

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BakeryApp extends JFrame {
    private BakeryManager manager;
    private JTextArea displayArea;

    public BakeryApp() {
        manager = new BakeryManager();
        setupSampleData();

        setTitle("Petal Crumbs - Bakery Order Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();
        JLabel title = new JLabel("Petal Crumbs Bakery");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        topPanel.add(title);

        // Center Panel
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton viewProducts = new JButton("View Products");
        JButton placeOrder = new JButton("Place Order");
        JButton saveOrders = new JButton("Save Orders");
        JButton loadOrders = new JButton("Load Orders");

        bottomPanel.add(viewProducts);
        bottomPanel.add(placeOrder);
        bottomPanel.add(saveOrders);
        bottomPanel.add(loadOrders);

        add(topPanel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        viewProducts.addActionListener(e -> viewProducts());
        placeOrder.addActionListener(e -> createOrder());
        saveOrders.addActionListener(e -> manager.saveOrdersToFile("orders.dat"));
        loadOrders.addActionListener(e -> manager.loadOrdersFromFile("orders.dat"));

        setVisible(true);
    }

    private void setupSampleData() {
        manager.addProduct(new Cake("Chocolate Cake", 250, "Chocolate", "Large"));
        manager.addProduct(new Cupcake("Vanilla Cupcake", 120, "Sprinkles", 6));
        manager.addProduct(new Pastry("Croissant", 30, "Butter"));
    }

    private void viewProducts() {
        StringBuilder sb = new StringBuilder("Available Products:\n\n");
        for (Product p : manager.getProducts()) {
            sb.append(p.toString()).append(" - ").append(p.getDescription()).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void createOrder() {
        try {
            String customerName = JOptionPane.showInputDialog("Enter customer name:");
            String contact = JOptionPane.showInputDialog("Enter contact number:");
            Customer customer = new Customer(customerName, contact);
            Order order = new Order(customer);

            for (Product p : manager.getProducts()) {
                String qtyStr = JOptionPane.showInputDialog("Enter quantity for " + p.getName() + " (0 to skip):");
                int qty = Integer.parseInt(qtyStr);
                if (qty > 0) order.addProduct(p, qty);
            }

            displayArea.setText(order.getSummary());
            manager.addOrder(order);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new BakeryApp();
    }
}