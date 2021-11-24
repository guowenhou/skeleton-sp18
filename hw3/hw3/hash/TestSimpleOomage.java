package hw3.hash;

import org.junit.Test;


import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class TestSimpleOomage {

    @Test
    public void testHashCodeDeterministic() {
        SimpleOomage so = SimpleOomage.randomSimpleOomage();
        int hashCode = so.hashCode();
        for (int i = 0; i < 100; i += 1) {
            assertEquals(hashCode, so.hashCode());
        }
    }

    @Test
    public void testHashCodePerfect() {
        /* TODO: Write a test that ensures the hashCode is perfect,
          meaning no two SimpleOomages should EVER have the same
          hashCode UNLESS they have the same red, blue, and green values!
         */
//        SimpleOomage ooA = new SimpleOomage(10, 10, 20);
//        SimpleOomage ooA2 = new SimpleOomage(5, 60, 20);

        for (int i = 1; i < 50; i++) {
            SimpleOomage ooA = new SimpleOomage(5*i, 0, 20);
            SimpleOomage ooA2 = new SimpleOomage(0, 5*i, 20);
            SimpleOomage ooA3 = new SimpleOomage(5, 5, i*5);
            System.out.println("ooA "+ooA);
            System.out.println("ooA2 "+ooA2);

            assertNotEquals(ooA.hashCode(),ooA2.hashCode());
            System.out.println("ooA "+ooA);
            System.out.println("ooA3 "+ooA3);
            assertNotEquals(ooA.hashCode(),ooA3.hashCode());
            System.out.println("ooA2 "+ooA2);
            System.out.println("ooA3 "+ooA3);
            assertNotEquals(ooA3.hashCode(),ooA2.hashCode());
        }

        HashSet<SimpleOomage> hashSet = new HashSet<>();
//        hashSet.add(ooA);
//        assertFalse(hashSet.contains(ooA2));
    }

    @Test
    public void testEquals() {
        SimpleOomage ooA = new SimpleOomage(5, 10, 20);
        SimpleOomage ooA2 = new SimpleOomage(5, 10, 20);
        SimpleOomage ooB = new SimpleOomage(50, 50, 50);
        assertEquals(ooA, ooA2);
        assertNotEquals(ooA, ooB);
        assertNotEquals(ooA2, ooB);
        assertNotEquals(ooA, "ketchup");
    }


    @Test
    public void testHashCodeAndEqualsConsistency() {
        SimpleOomage ooA = new SimpleOomage(0, 0, 5);
        SimpleOomage ooA2 = new SimpleOomage(0,5, 0);
        System.out.println(ooA.equals(ooA2));

        HashSet<SimpleOomage> hashSet = new HashSet<>();
        hashSet.add(ooA);
        assertFalse(hashSet.contains(ooA2));
    }

    /* TODO: Uncomment this test after you finish haveNiceHashCode Spread in OomageTestUtility */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(SimpleOomage.randomSimpleOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }

    /** Calls tests for SimpleOomage. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestSimpleOomage.class);
    }
}
