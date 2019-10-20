package jpashop.builder;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Member {

    private String name;

    @Builder.Default
    private String city = "안양시";
    private String street;
    private String zipcode;

}
