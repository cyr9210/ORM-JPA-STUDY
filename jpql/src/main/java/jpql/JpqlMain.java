package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpqlMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {
      Product product = new Product();
      product.setName("product");
      product.setPrice(1000);
      product.setStockAmount(100);

      Order order = new Order();
      order.setOrderAmount(1);
      order.setProduct(product);
      product.getOrders().add(order);

      em.persist(product);

      System.out.println("flush");
      em.flush();
      em.clear();
      System.out.println("=========");


      Product product1 = em.find(Product.class, 1L);
      product1.getOrders().size();

      Order order2 = new Order();
      order2.setOrderAmount(2);

      product1.addOrders(order2);


      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }

  private static Team createTeam(String name) {
    Team team = new Team();
    team.setName(name);
    return team;
  }

  private static Member createMember(String name, int age, Team team) {
    Member member = new Member();
    member.setName(name);
    member.setAge(age);
    member.setTeam(team);
    return member;
  }
}
