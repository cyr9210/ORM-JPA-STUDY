package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("test");
            member.setCreatedBy("user");
            member.setCreatedDate(LocalDateTime.now());

            em.flush();
            em.clear();

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
