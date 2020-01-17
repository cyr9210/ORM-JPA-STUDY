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
//      Team team = new Team();
//      team.setName("teamA");
//      em.persist(team);
//
//      Member member = createMember("member", 10);
//      member.changeTeam(team);
//      em.persist(member);
//
//      em.flush();
//      em.clear();

      List<Member> resultList = em.createQuery("select m.name, 'HELLO', TRUE from Member m " +
                                                        "where m.memberType = :userType")
          .setParameter("userType", MemberType.ADMIN)
          .getResultList();

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
