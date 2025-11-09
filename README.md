# Petal Crumbs Bakery Order Management System
Lanuage: Java

GUI Framework: Swing (JFrame)

Concept: Manage bakery products, handle customer orders, and calculate totals in a real world bakery management system.
# Overall
*Petal Crumbs* is a Java desktop application that allows bakery owners to manage their daily orders, track products, and generate receipts.

It's designed using Object-Oriented Programming principles(inheritance, polymorphism, encapsulation) and includes GUI, collections, file handling, and exception handling.
# Features
Product Management:
View and manage bakery items (cakes, cupcakes, pastries).

Customer Orders:
Add customer details, select products, and generate order summaries.

File Handling:
Save and load daily orders using object serialization (.dat files).

Automatic Totals:
Calculates order totals dynamically.

Exception Handling:
Handles invalid inputs and file errors gracefully.

GUI Interface:
Built with Java Swing using JFrame, JPanel, JButton, and JTextArea.

# Object-Oriented Design
Product (abstract)
 
 ├── Cake
 
 ├── Cupcake
 
 └── Pastry

Customer

Order

BakeryManager

BakeryApp (Main GUI)

Each subclass extends the Product superclass, demonstrating inheritance and polymorphism.

# File Structure
PetalCrumbs/

│

├── src/

│   ├── Product.java

│   ├── Cake.java

│   ├── Cupcake.java

│   ├── Pastry.java

│   ├── Customer.java

│   ├── Order.java

│   ├── BakeryManager.java

│   └── BakeryApp.java

│

└── README.md
# About the Developer
Hi! I’m Iman Adams, a computer science student from Cape Town passionate about building real world software projects.

This project showcases my skills in Java, GUI design, and Object-Oriented Programming.
I’m currently building a portfolio to grow as a developer and gain professional experience.
