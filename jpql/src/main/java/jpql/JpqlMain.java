package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpqlMain {

  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
    tx.begin();

    try {

      for (int i = 0; i < 100; i++) {
        Member member = createMember("member", i);
        em.persist(member);
      }

      em.flush();
      em.clear();

      String query = "select " +
          "case when m.age <= 10 then '학생요금'" +
          "when m.age >= 60 then '경로요금'" +
          "else '일바요금'" +
          "end " +
          "from Member m";

      List<String> resultList = em.createQuery(query, String.class).getResultList();

      for (String s : resultList) {
        System.out.println(s);
      }

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }

  private static Member createMember(String name, int age) {
    Member member = new Member();
    member.setName(name);
    member.setAge(age);
    return member;
  }
}
