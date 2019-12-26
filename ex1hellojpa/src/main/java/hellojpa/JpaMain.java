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
            team.setName("team1");

            Member member = new Member();
            member.setUsername("1");
            member.setTeam(team);

            Member member2 = new Member();
            member2.setUsername("2");
            member2.setTeam(team);

            em.persist(team);
            em.persist(member);
            em.persist(member2);

//            em.flush();
//            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            Team findTeam = em.find(Team.class, team.getId());
            em.remove(findTeam);
//            Member findMember2 = em.find(Member.class, member2.getId());
//            em.remove(findMember);
//            em.remove(findMember2);

            em.clear();

            System.out.println("test" + findMember.getUsername());

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
