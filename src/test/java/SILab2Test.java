import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testEveryStatement() {
        RuntimeException ex;
        List<String> users=new ArrayList<>();
        users.add("ines");
        User user=null;
        //A, B, P
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, users));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        //A, C, D, P
        user=new User("ines", "abc", "random");
        User finalUser = user;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(finalUser, users));
        assertTrue(ex.getMessage().contains("User already exists!"));

        // A, C, E, F, P
        user=new User("ana", "abc", null);
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, H.2, I, K, H.3, M, N, P
        user=new User("angela", "abc", "");
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, H.2, I, J, K, L, H.3, M, O, P
        user=new User("ines1", "abc", "ines@gmail.com");
        assertTrue(SILab2.function(user, users));
    }
    @Test
    void testEveryPath() {
        RuntimeException ex;
        List<String> users=new ArrayList<>();
        users.add("ines");
        User user;
        //A, B, P
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, users));
        assertTrue(ex.getMessage().contains("The user argument is not initialized!"));

        //A, C, D, P
        user=new User("ines", "abc", "random");
        User finalUser = user;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(finalUser, users));
        assertTrue(ex.getMessage().contains("User already exists!"));

        //A, C, E, F, P
        user=new User("ana", "abc", null);
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, H.2, M, O, P (mailot e prazen string, ne e vozmozhno)

        //A, C, E, G, H.1, H.2, M, N, P
        user=new User("angela", "abc", "");
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, (H.2, I, K, H.3), M, N, P
        user=new User("angela", "abc", "abc");
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, (H.2, I, K, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)

        //A, C, E, G, H.1, (H.2, I, J, K, H.3), M, N, P
        user=new User("angela", "abc", "abc@");
        assertFalse(SILab2.function(user, users));

        //A, C, E, G, H.1, (H.2, I, J, K, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)

        //A, C, E, G, H.1, (H.2, I, K, L, H.3), M, N, P (ne mozhe da otide do K, ako barem ednash ne otide do J)

        //A, C, E, G, H.1, (H.2, I, K, L, H.3), M, O, P (ne e validen emailot, ne e vozmozhno)

        //A, C, E, G, H.1, (H.2, I, J, K, L, H.3), M, N, P (emailot e validen, ne e vozmozhno)

        //A, C, E, G, H.1, (H.2, I, J, K, L, H.3), M, O, P
        user=new User("ines1", "abc", "ines@gmail.com");
        assertTrue(SILab2.function(user, users));
    }
}