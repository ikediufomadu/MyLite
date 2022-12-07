import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Retailanime extends JFrame{
    private JPanel panelMain;
    private JButton customerButton;
    private JButton vendorButton;
    private JPanel navBar;
    private JTabbedPane tabbedPane1;
    private JPanel CustomerView;
    private JPanel VendorView;
    private JButton shopButton;
    private JButton cartButton;
    private JButton profileButton;
    private JButton supportButton;
    private JButton reviewButton;
    private JButton productsButton;
    private JButton reviewsButton;
    private JButton ordersButton;
    private JButton analyticsButton;
    private JButton issuesButton;
    private JPanel customerActions;
    private JPanel vendorActions;
    private JTabbedPane CurrentView;
    private JTabbedPane CurrentView2;
    private JComboBox catalogList;
    private JList cartList;
    private JTextField nameTxtbox;
    private JTextField AdressTxtbox;
    private JTextField HouseTxtbox;
    private JTextField CityTxtbox;
    private JTextField CountryTxtbox;
    private JButton btnSaveProfile;
    private JTextField IssueTxtbox;
    private JButton btnSubmitIssue;
    private JTextField DescripTxtbox;
    private JButton addToCartButton;
    private JComboBox reviewSelection;
    private JTextField reviewTxtbox;
    private JButton btsSubmitReview;
    private JList productsView;
    private JButton deleteProd;
    private JList reviewView;
    private JButton viewReview;
    private JButton blockReview;
    private JList orderView;
    private JButton modifyOrder;
    private JList issuesView;
    private JButton respondIssue;
    private JButton markAsDone;
    private JButton btnChangQty;
    private JButton removeCart;
    private JTextField reviewTitle;
    private JPanel mainContent;

    public Retailanime()
            throws SQLException, ClassNotFoundException
    {

        String url
                = "jdbc:mysql://triton.towson.edu:3360/jhunat1db"; // table details
        String username = "jhunat1"; // MySQL credentials
        String password = "COSC*laz7p";
        String query = "select *from student"; // query to be run
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name

        Connection con = DriverManager.getConnection(
                url, username, password);
        System.out.println(
                "Connection Established successfully");
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(query); // Execute query
        rs.next();
        String name
                = rs.getString("FirstName"); // Retrieve name from db




        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(0);
            }
        });
        vendorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane1.setSelectedIndex(1);
            }
        });



        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView.setSelectedIndex(0);
                catalogList.removeAllItems();

                try {
                    ResultSet res = st.executeQuery("SELECT ItemName from Item");
                    while(res.next()) {
                        catalogList.addItem(res.getString("ItemName"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView.setSelectedIndex(1);

                try {
                    DefaultListModel model = new DefaultListModel();
                    ResultSet res = st.executeQuery("SELECT * FROM Item, Orders WHERE C_id = 1234");
                    while(res.next()) {
                        String Item = res.getString("ItemName");
                        model.addElement(Item);
                    }
                    cartList.setModel(model);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView.setSelectedIndex(2);

                try {
                    ResultSet res = st.executeQuery("SELECT * FROM jhunat1db.Customer");
                    res.next();
                    nameTxtbox.setText(res.getString("Name"));
                    AdressTxtbox.setText(res.getString("Address"));
                    HouseTxtbox.setText(res.getString("House"));
                    CityTxtbox.setText(res.getString("Subregion"));
                    CountryTxtbox.setText(res.getString("Country"));
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        supportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView.setSelectedIndex(3);
            }
        });
        reviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView.setSelectedIndex(4);
                reviewSelection.removeAllItems();

                try {
                    ResultSet res = st.executeQuery("SELECT ItemName FROM Item WHERE Item_id = 777");
                    while(res.next()) {
                        reviewSelection.addItem(res.getString("ItemName"));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        productsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView2.setSelectedIndex(0);

                try {
                    DefaultListModel model = new DefaultListModel();
                    ResultSet res = st.executeQuery("SELECT * FROM Item");
                    while(res.next()) {
                        String Item = res.getString("ItemName");
                        model.addElement(Item);
                    }
                    productsView.setModel(model);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        deleteProd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reviewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView2.setSelectedIndex(1);

                try {
                    DefaultListModel model = new DefaultListModel();
                    ResultSet res = st.executeQuery("SELECT * FROM Review");
                    while(res.next()) {
                        String Item = "Rating: " + res.getString("Rating") + ", \nDescription: " + res.getString("Descrip");
                        model.addElement(Item);
                    }
                    reviewView.setModel(model);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        viewReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    DefaultListModel model = new DefaultListModel();
                    ResultSet res = st.executeQuery("SELECT * FROM Review");
                    while(res.next()) {
                        String Item = "Rating: " + res.getString("Rating") + ", \nDescription: " + res.getString("Descrip");
                        model.addElement(Item);
                    }

                    JOptionPane.showMessageDialog(null, model.elementAt(reviewView.getSelectedIndex()).toString());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }


            }
        });
        ordersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView2.setSelectedIndex(2);

                try {
                    DefaultListModel model = new DefaultListModel();
                    ResultSet res = st.executeQuery("SELECT * FROM Orders");
                    while(res.next()) {
                        String Item = "Customer ID: " + res.getString("C_id") + ", Order ID: " + res.getString("Order_id") + ", Progress: " + res.getString("Progress");
                        model.addElement(Item);
                    }
                    orderView.setModel(model);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        analyticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView2.setSelectedIndex(3);
            }
        });
        issuesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CurrentView2.setSelectedIndex(4);
            }
        });


        btnSaveProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTxtbox.getText();
                String address = AdressTxtbox.getText();
                String House = HouseTxtbox.getText();
                String Subregion = CityTxtbox.getText();
                String Country = CountryTxtbox.getText();

                try {
                    int x = st.executeUpdate("UPDATE Customer set " +
                            "Name = \" " + name + " \" " +
                            ",Address = \" " + address + " \" " +
                            ",House = \" " + House + " \" " +
                            ",Subregion = \" " + Subregion + " \" " +
                            ",Country = \" " + Country + " \" ");

                    if (x > 0)
                        System.out.println("Password Successfully Updated");
                    else
                        System.out.println("ERROR OCCURRED :(");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnSubmitIssue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String descrip = DescripTxtbox.getText();
                String reason = IssueTxtbox.getText();

                try {
                    int x = st.executeUpdate("UPDATE Issue set " +
                            "Descrip = \" " + descrip + " \" " +
                            ",Reason = \" " + reason + " \" " +
                            ",Ord_id = " + 5678 +
                            ",Cust_id =  " + 1234 +
                            ",Itm_id =  " + 420);

                    if (x > 0)
                        System.out.println("Password Successfully Updated");
                    else
                        System.out.println("ERROR OCCURRED :(");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        reviewSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reviewTitle.setEnabled(true);
                reviewTxtbox.setEnabled(true);
                btsSubmitReview.setEnabled(true);

            }
        });

        btsSubmitReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String rating = reviewTitle.getText();
                String descrip = reviewTxtbox.getText();

                try {
                    int x = st.executeUpdate("INSERT Review set " +
                            "Rating = \" " + rating + " \" " +
                            ",Descrip = \" " + descrip + " \" " +
                            ",Item_I = " + 777);

                    if (x > 0)
                        System.out.println("Password Successfully Updated");
                    else
                        System.out.println("ERROR OCCURRED :(");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        modifyOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Modify Order");
                JLabel label1 = new JLabel("Order ID: ");
                JTextField orderid = new JTextField();
                JLabel label2 = new JLabel("Progress: ");
                JTextField prog = new JTextField();
                JLabel label3 = new JLabel("Customer ID: ");
                JTextField custID = new JTextField();
                JLabel label4 = new JLabel("Post Code: ");
                JTextField post = new JTextField();
                JLabel label5 = new JLabel("Country: ");
                JTextField country = new JTextField();
                JButton btnSubmitChange = new JButton("Submit");
                frame.setBounds(300, 200, 720, 360);
                frame.setVisible(true);

            }
        });
    }

    public static void main(String[] args)
        throws SQLException, ClassNotFoundException
    {
        Retailanime h = new Retailanime();
        h.setContentPane(h.panelMain);
        h.setTitle("Retailanime");
        h.setBounds(300, 200, 1280, 720);
//        h.setSize(300, 400);
        h.setVisible(true);
        h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        /*String url
                = "jdbc:mysql://triton.towson.edu:3360/jhunat1db"; // table details
        String username = "jhunat1"; // MySQL credentials
        String password = "COSC*laz7p";
        String query = "select *from student"; // query to be run
        Class.forName("com.mysql.cj.jdbc.Driver"); // Driver name

        Connection con = DriverManager.getConnection(
                url, username, password);
        System.out.println(
                "Connection Established successfully");
        Statement st = con.createStatement();

        ResultSet rs
                = st.executeQuery(query); // Execute query
        rs.next();
        String name
                = rs.getString("FirstName"); // Retrieve name from db




        System.out.println(name); // Print result on console
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");*/
    }


    /*public class Order implements Serializable{
        private int Order_id;
        private int Progress;
        private int C_id;
        private int PostalCode;
        private String Country;

        public Order()
        {

        }

        public Order(int Order_id,int Progress, int C_id, int PostalCode, String Country)
        {
            this.Order_id = Order_id;
            this.Progress = Progress;
            this.C_id = C_id;
            this.PostalCode = PostalCode;
            this.Country = Country;
        }

        public int getOrder_id() {
            return Order_id;
        }

        public void setOrder_id(int order_id) {
            Order_id = order_id;
        }

        public int getProgress() {
            return Progress;
        }

        public void setProgress(int progress) {
            Progress = progress;
        }

        public int getC_id() {
            return C_id;
        }

        public void setC_id(int c_id) {
            C_id = c_id;
        }

        public int getPostalCode() {
            return PostalCode;
        }

        public void setPostalCode(int postalCode) {
            PostalCode = postalCode;
        }

        public String getCountry() {
            return Country;
        }

        public void setCountry(String country) {
            Country = country;
        }
    }*/
}

