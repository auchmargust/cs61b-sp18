import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HorribleSteve {
    @Test
    public void testFlik() {
        assertTrue(Flik.isSameNumber(500, 500));
    }

    //    public static void main(String[] args) {
//        int i = 0;
//        for (int j = 0; i < 500; ++i, ++j) {
//            if (!Flik.isSameNumber(i, j)) {
//                break; // break exits the for loop!
//            }
//        }
//        System.out.println("i is " + i);
//    }
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", HorribleSteve.class);
    }

}
