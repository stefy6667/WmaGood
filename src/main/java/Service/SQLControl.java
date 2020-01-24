package Service;

import Model.OrderModel;
import Model.PrepareOrder;
import Model.Product;
import Model.UserModel;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLControl {
    private String result;

    public ArrayList<Product> selectAllProductBar() throws SQLException {
        ArrayList<Product> pArrList = new ArrayList<Product>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from Product where category = 'bar'";

        List<Product> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {
            String pId = rs.get(i).getpId();
            String pName = rs.get(i).getpName();
            String quntity = rs.get(i).getQuantity();
            String category = rs.get(i).getCategory();
            Double pPrice = rs.get(i).getpPrice();
            pArrList.add(new Product(pId, pName, category, quntity, pPrice));
        }
        sessionq.close();
        return pArrList;
    }

    public ArrayList<Product> selectAllProductBuc() throws SQLException {
        ArrayList<Product> pArrList = new ArrayList<Product>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from Product where category = 'kitchen'";

        List<Product> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {
            String pId = rs.get(i).getpId();
            String pName = rs.get(i).getpName();
            String category = rs.get(i).getCategory();
            String quaniti = rs.get(i).getQuantity();
            Double pPrice = rs.get(i).getpPrice();
            pArrList.add(new Product(pId, pName, category, quaniti, pPrice));
        }
        sessionq.close();
        return pArrList;
    }

    public ArrayList<Product> selectAllProducthookah() throws SQLException {
        ArrayList<Product> pArrList = new ArrayList<Product>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from Product where category = 'hookah'";

        List<Product> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {
            String pId = rs.get(i).getpId();
            String pName = rs.get(i).getpName();
            String category = rs.get(i).getCategory();
            String quantiti = rs.get(i).getQuantity();
            Double pPrice = rs.get(i).getpPrice();
            pArrList.add(new Product(pId, pName, category, quantiti, pPrice));
        }
        sessionq.close();
        return pArrList;
    }

    public ArrayList<Product> selectProduct(String id) throws SQLException {
        ArrayList<Product> arrCart = new ArrayList<Product>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String xSQL = "from Product where pId = " + id;

        List<Product> rs = session.createQuery(xSQL).list();


        for (int i = 0; i < rs.size(); i++) {
            String pId = rs.get(i).getpId();
            String pName = rs.get(i).getpName();
            String category = rs.get(i).getCategory();
            Double pPrice = rs.get(i).getpPrice();
            arrCart.add(new Product(pId, pName, category, pPrice));
        }
        session.close();
        return arrCart;
    }

    public void insertOrder(String tableName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String query = "CREATE TABLE Wama. " + tableName + " (tableId VARCHAR(40), pID VARCHAR(40),pName VARCHAR(40) ,category VARCHAR(40),quantity INT, price DOUBLE,ready VARCHAR(40), date VARCHAR(40))";
        session.createSQLQuery(query).executeUpdate();
        session.close();
    }

    public void insertOrderLine(String orderName, String tableId, String pID, String pName, String category, int quantity, Double price, String ready, String date) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery("INSERT INTO " + orderName + " VALUES (" + "'" + tableId + "'" + "," + "'" + pID + "'" + " ," + "'" + pName + "'" + "," +
                "'" + category + "'" + "," + quantity + "," + price + " ," + "'" + ready + "'" + "," + "'" + date + "'" + ")").executeUpdate();
        session.getTransaction().commit();
        session.close();


    }

    public void createOrder(String WaiterId, String orderNumber, String table, String ready, String readyBuc, String readyNar, String deliver, String date, Double total) {
        org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        OrderModel order = new OrderModel(WaiterId, orderNumber, table, ready, readyBuc, readyNar, deliver, date, total);


        session.save(order);
        session.getTransaction().commit();
        session.close();


    }

    public ArrayList<OrderModel> orderStatus() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where readyBar !='DeliverBar'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> orderStatusBuc() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where  readyBuc !='DeliverBuc' ";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> orderStatusNar() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where getReadyNar !='DeliverNar'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> orderNameBar() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where readyBar='notReady'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> orderNameNar() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where getReadyNar='notReady'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> orderNameBuc() throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where readyBuc='notReady'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public List<PrepareOrder> prepareOrderBar(String orderName) {
        List<PrepareOrder> pArrList = new ArrayList<PrepareOrder>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();

        String sql = "select pName,quantity,tableId,price from " + orderName + " WHERE category = 'bar' AND  ready = 'notReady'";
        NativeQuery query = sessionq.createSQLQuery(sql);
        query.addEntity(PrepareOrder.class);
        List<PrepareOrder> rs = query.list();

        for (PrepareOrder product : rs) {

            String name = product.getpName();
            String quantity = product.getQuantity();
            String table = product.getTable();
            double price = product.getPrice();

            pArrList.add(new PrepareOrder(name, quantity, table, price));
        }

        sessionq.close();
        return pArrList;
    }

    public List<PrepareOrder> prepareOrderKitchen(String orderName) {
        List<PrepareOrder> pArrList = new ArrayList<PrepareOrder>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();

        String sql = "select pName,quantity,tableId,price from " + orderName + " WHERE category = 'kitchen' AND ready ='notReady'";
        NativeQuery query = sessionq.createSQLQuery(sql);
        query.addEntity(PrepareOrder.class);
        List<PrepareOrder> rs = query.list();

        for (PrepareOrder product : rs) {

            String name = product.getpName();
            String quantity = product.getQuantity();
            String table = product.getTable();
            double price = product.getPrice();

            pArrList.add(new PrepareOrder(name, quantity, table, price));
        }

        sessionq.close();
        return pArrList;
    }

    public List<PrepareOrder> prepareOrderHookah(String orderName) {
        List<PrepareOrder> pArrList = new ArrayList<PrepareOrder>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();

        String sql = "select pName,quantity,tableId,price from " + orderName + " WHERE category = 'hookah' AND ready = 'notReady'";
        NativeQuery query = sessionq.createSQLQuery(sql);
        query.addEntity(PrepareOrder.class);
        List<PrepareOrder> rs = query.list();

        for (PrepareOrder product : rs) {

            String name = product.getpName();
            String quantity = product.getQuantity();
            String table = product.getTable();

            double price = product.getPrice();

            pArrList.add(new PrepareOrder(name, quantity, table, price));
        }

        sessionq.close();
        return pArrList;
    }

    public void updateTable(String tName, String ready, String Message1, String message2) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE OrderModel SET deliver =" + "'" + Message1 + "'" + "," + ready + " = " + message2 + " Where orderNumber = '" + tName + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }

    public void updateStatus(String tName, String col, String Message1) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE OrderModel SET " + col + "  =" + "'" + Message1 + "'" + " Where orderNumber = '" + tName + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }

    public void updateStatus1(String table, String col, String Message1, String pname) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE " + table + " SET " + col + "  =" + "'" + Message1 + "'" + " Where pName = '" + pname + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }

    public List<PrepareOrder> CheckOut(String orderName) {
        List<PrepareOrder> pArrList = new ArrayList<PrepareOrder>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();

        String sql = "select pName,quantity,tableId ,price from " + orderName + "";
        NativeQuery query = sessionq.createSQLQuery(sql);
        query.addEntity(PrepareOrder.class);
        List<PrepareOrder> rs = query.list();

        for (PrepareOrder product : rs) {

            String name = product.getpName();
            String quantity = product.getQuantity();
            String table = product.getTable();
            double price = product.getPrice();


            pArrList.add(new PrepareOrder(name, quantity, table, price));
        }

        sessionq.close();
        return pArrList;
    }

    public ArrayList<OrderModel> CheckOutOrdeName(String tableId) throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where deliver='notDeliver' and tabel =" + tableId;

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public String order(String tableId) {
        ArrayList<OrderModel> arr = new ArrayList<>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "FROM OrderModel where deliver='notDeliver' and tabel =" + tableId;
        List<OrderModel> rs = sessionq.createQuery(sql).list();

        for (int i = 0; i < rs.size(); i++) {
            result = rs.get(i).getOrderNumber();
        }
        sessionq.close();
        return result;
    }

    public void addProduct(Product product) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();


        sessionq.save(product);
        sessionq.getTransaction().commit();



    }

    public void deleteById(Integer id) {
        org.hibernate.Session session3 = HibernateUtil.getSessionFactory().openSession();
        session3.beginTransaction();

        Product result = (Product) session3.load(Product.class, id);
        session3.delete(result);

        session3.getTransaction().commit();

    }
    public void deleteUserById(Integer id) {
        org.hibernate.Session session3 = HibernateUtil.getSessionFactory().openSession();
        session3.beginTransaction();

        UserModel result = session3.load(UserModel.class, id);
        session3.delete(result);

        session3.getTransaction().commit();

    }

    public List<Product> getAllUsers() {
        org.hibernate.Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        ArrayList<Product> products = new ArrayList<>();

        List<Product> result = session2.createQuery("from Product ").list();

        for (int i = 0; i < result.size(); i++) {
            int id = result.get(i).getId();
            String pId = result.get(i).getpId();
            String pName = result.get(i).getpName();
            String category = result.get(i).getCategory();
            String quantity = result.get(i).getQuantity();
            double pPrice = result.get(i).getpPrice();
            products.add(new Product(id, pId, pName, category, quantity, pPrice));
        }

        session2.getTransaction().commit();


        return products;
    }
    public List<UserModel> getAllPers() {
        org.hibernate.Session session2 = HibernateUtil.getSessionFactory().openSession();
        session2.beginTransaction();
        ArrayList<UserModel> products = new ArrayList<>();

        List<UserModel> result = session2.createQuery("from UserModel ").list();

        for (int i = 0; i < result.size(); i++) {
            int id = result.get(i).getId();
            String pId = result.get(i).getName();
            String pName = result.get(i).getPermision();
            String category = result.get(i).getCodeId();

            products.add(new UserModel(id,pId, pName, category));
        }

        session2.getTransaction().commit();


        return products;
    }

    public void updateQuantiti(String Message1, String pname) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE Product SET quantity = quantity +" + "'" + Message1 + "'" + " Where pId = '" + pname + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }

    public void updateQuantitiOrder(int Message1, String pname) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE Product SET quantity = quantity -" + "'" + Message1 + "'" + " Where pId = '" + pname + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }
    public  void AddUser(UserModel user){
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        sessionq.save(user);
        sessionq.getTransaction().commit();
        sessionq.close();

    }
    public void updateTotal(String Message1, String pname) {
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "UPDATE OrderModel SET total = total +" + "'" + Message1 + "'" + " Where orderNumber = '" + pname + "'";
        sessionq.createSQLQuery(sql).executeUpdate();
        sessionq.close();

    }

    public ArrayList<OrderModel> OrderMounth(int mounth) throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from OrderModel where month(date)=" + mounth;

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public ArrayList<OrderModel> OrderWaiter(String name) throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from OrderModel where WaiterId=" + "'" + name + "'";

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public List<PrepareOrder> OrderByName(String orderName) {
        List<PrepareOrder> pArrList = new ArrayList<PrepareOrder>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();

        String sql = "select pName,quantity,tableId,price from " + orderName;
        NativeQuery query = sessionq.createSQLQuery(sql);
        query.addEntity(PrepareOrder.class);
        List<PrepareOrder> rs = query.list();

        for (PrepareOrder product : rs) {

            String name = product.getpName();
            String quantity = product.getQuantity();
            String table = product.getTable();
            double price = product.getPrice();

            pArrList.add(new PrepareOrder(name, quantity, table, price));
        }

        sessionq.close();
        return pArrList;
    }

    public ArrayList<OrderModel> OrderToday(int mounth) throws SQLException {
        ArrayList<OrderModel> order = new ArrayList<OrderModel>();
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "from OrderModel where day(date)=" + mounth;

        List<OrderModel> rs = sessionq.createQuery(sql).list();


        for (int i = 0; i < rs.size(); i++) {

            String WaiterId = rs.get(i).getWaiterId();
            String orderName = rs.get(i).getOrderNumber();
            String table = rs.get(i).getTabel();
            String ready = rs.get(i).getReady();
            String readyBuc = rs.get(i).getReadyBuc();
            String readyNar = rs.get(i).getGetReadyNar();
            String deliver = rs.get(i).getDeliver();
            String date = rs.get(i).getDate();
            double total = rs.get(i).getTotal();

            order.add(new OrderModel(WaiterId, orderName, table, ready, readyBuc, readyNar, deliver, date, total));
        }
        sessionq.close();
        return order;
    }

    public Double totalThisMounth(int mounth) throws SQLException {
        Double value = 0.0;
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "select SUM(total) AS Total from OrderModel where month(date)=" + mounth;
        List res = sessionq.createQuery(sql).list();
        String sum = "";
        if (res.get(0) != null) {
            sum = res.get(0).toString();
        }else{
            sum="0";
        }
        System.out.println("SUM  " + sum);
        value = Double.parseDouble(sum);
        sessionq.close();
        return value;
    }

    public Double totalToday(int mounth) throws SQLException {
        Double value = 0.0;
        Session sessionq = HibernateUtil.getSessionFactory().openSession();
        sessionq.beginTransaction();
        String sql = "select SUM(total) AS Total from OrderModel where day(date)=" + mounth;
        List res = sessionq.createQuery(sql).list();
        String sum = "";
        if (res.get(0) != null) {
            sum = res.get(0).toString();
        } else {
            sum = "0";
        }
        System.out.println("SUM  " + sum);
        value = Double.parseDouble(sum);
        sessionq.close();
        return value;
    }
}
