package jpashop.builder;

public class BuilderTest {

    public static void main(String[] args) {
        Member member = Member.builder()
                .name("bong")
                .build();

        System.out.println(member);
    }
}
