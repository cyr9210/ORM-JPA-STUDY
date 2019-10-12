package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("team A");
            em.persist(team);

            Member member = new Member();
            member.setUsername("bong");
            member.setTeam(team);
            em.persist(member);

            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findTeam.name : " + findMember.getTeam().getName());

            Team newTeam = new Team();
            newTeam.setName("updateTeam");
            em.persist(newTeam);

            findMember.setTeam(newTeam);
            System.out.println("update findTeam.name : " + findMember.getTeam().getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static Member createMember(String username) {
        Member member = new Member();
        member.setUsername(username);
        return member;
    }
}
