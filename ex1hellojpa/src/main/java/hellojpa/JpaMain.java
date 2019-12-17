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

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("member.username = " + username);

        Team team = member.getTeam();
        System.out.println("team.teamName = " + team.getName());
    }

    private static void printMember(Member member) {
        System.out.println("member.username = " + member.getUsername());
    }

    private static Member createMember(String username) {
        Member member = new Member();
        member.setUsername(username);
        return member;
    }
}
