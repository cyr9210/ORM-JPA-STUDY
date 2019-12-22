package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            MemberForEmbeded member = new MemberForEmbeded();
            member.setUsername("bong");
            member.setHomeAddress(new Address("city", "street", "1000"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new Address("old1" ,"street", "1000"));
            member.getAddressHistory().add(new Address("old2" ,"street", "1000"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("===========================");
            MemberForEmbeded findMember = em.find(MemberForEmbeded.class, member.getId());

            findMember.getFavoriteFoods().remove("치킨");
            findMember.getFavoriteFoods().add("한식");

            findMember.getAddressHistory().remove(new Address("old1", "street", "1000"));
            findMember.getAddressHistory().add(new Address("new1", "street", "1000"));

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
