package oned.b2b;

import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class AssertJExampleTest {

    @Test
    public void testMethodInt(){
        int[] methodInt = new int[]{1,2,3,4,5,6};
        assertThat(methodInt).contains(6)
                .isNotEmpty()
                .hasSize(6)
                .containsSequence(1,2);

    }

    @Test
    public  void testString(){
        String say = "Chị không muốn nhiều bug nhưng bug nhiều nên chị phải fix";
        String sayClone = say;
       assertThat(say).isNotNull()
               .startsWith("Chị")
               .doesNotContain("Anh")
               .endsWith("fix")
               .contains("bug");
       assertThat(say).isEqualTo(sayClone);

    }
    @Test
    public  void testNumber(){
        Double value = 12.0;
        Double value1 = 10.0;
        assertThat(value).isEqualTo(12.0);
        assertThat(value).isCloseTo(15.0, Offset.offset(4d));
        assertThat(value1).isStrictlyBetween(9.0, 15.0);
        assertThat(value).isBetween(10.0,15.0);

    }

//Viết test case để kiểm tra số điện thoại, số điện thoại bắt đầu từ 0, có 10 số, không có chữ
    @Test
    @DisplayName("Test Case phone number")
    public void  testPhoneNumber() {
        String phoneNumber = "0919348512";
        assertThat(phoneNumber).startsWith("0")
                .hasSize(10)
                .containsOnlyDigits();

    }

    @Test
    public void testEmail() {
        String email ="yenlt6@onemount.com";
                assertThat(email).contains("@")
                        .doesNotContain("#$%^&*()!~+?:{}[]")
                        .contains(".");
    }

    @Test
    public void testEmail2() {
        String email = "hien@onemount.com";
        assertThat(email).containsPattern("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
    }
}