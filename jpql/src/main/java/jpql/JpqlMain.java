package jpql;

import java.util.List;
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

      Team teamA = createTeam("팀A");
      Team teamB = createTeam("팀B");
      Team teamC = createTeam("팀C");
      em.persist(teamA);
      em.persist(teamB);
      em.persist(teamC);

      em.persist(createMember("회원1", 20, teamA));
      em.persist(createMember("회원2", 20, teamB));
      em.persist(createMember("회원3", 20, teamA));
      em.persist(createMember("회원4", 20, null));


      String query = "update Member m set m.age = 30";

      int result = em.createQuery(query).executeUpdate();
      System.out.println(result);

      List<Member> members = em.createQuery("select m from Member m", Member.class)
          .getResultList();

      for (Member member : members) {
        System.out.println(member);
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
