import Launch.Launch;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class Du {
    @Test
    public void test1() {
        String[] args = {"files/N2.txt"};
        List list1 = new ArrayList();
        list1.add("Размер files/N2.txt равен 3 KB");
        Launch.main(args);
        assertEquals(Launch.list, list1);
    }

    @Test
    public void test2() {
        String[] args = {"-c", "files/N1", "files/N2.txt"};
        List list1 = new ArrayList();
        list1.add("Суммарный размер файлов равен 5");
        Launch.main(args);
        assertEquals(Launch.list, list1);
    }

    @Test
    public void test3() {
        String[] args = {"-c", "-h", "files/N1", "files/N2.txt"};
        List list1 = new ArrayList();
        list1.add("Суммарный размер файлов равен 5 KB");
        Launch.main(args);
        assertEquals(Launch.list, list1);
    }

    @Test
    public void test4() {
        String[] args = {"-h", "files/N2.txt"};
        List list1 = new ArrayList();
        list1.add("Размер files/N2.txt равен 3 KB");
        Launch.main(args);
        assertEquals(Launch.list, list1);
    }


}