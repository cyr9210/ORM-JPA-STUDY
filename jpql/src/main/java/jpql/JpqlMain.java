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
      Member member = new Member();
      member.setName("bong");
      member.setAge(10);
      em.persist(member);

      List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.name, m.age) from Member m", MemberDTO.class)
          .getResultList();

      MemberDTO result = resultList.get(0);
      System.out.println(result.getName());
      System.out.println(result.getAge());

      tx.commit();
    } catch (Exception e) {
      tx.rollback();
      e.printStackTrace();
    } finally {
      em.close();
    }

    emf.close();
  }
}
