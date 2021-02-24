import com.multithread.ForkJoinSum;
import com.multithread.ListProducer;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForkJoinSumTest {
    private static final int NUMBER_OF_VALUES = 1000_000;
    private static final int MAX_LIST_VALUE = 1;

    @Test
    void getSumLargeArray_Ok() {
        List<Long> testList = ListProducer.getLongList(NUMBER_OF_VALUES, MAX_LIST_VALUE);
        ForkJoinSum forkJoinSum = new ForkJoinSum(testList);
        Long actual = forkJoinSum.compute();
        Assertions.assertEquals(1000_000, actual);
    }

    @Test
    void getSumPositiveElements_ok() {
        List<Long> testList = List.of(20L, 30L, 40L, 50L, 60L, 70L, 80L, 90L, 100L);
        ForkJoinSum forkJoinSum = new ForkJoinSum(testList);
        Long actual = forkJoinSum.compute();
        Assertions.assertEquals(540, actual);
    }

    @Test
    void getSumNegativeElements_ok() {
        List<Long> testList = List.of(-20L, -30L, -40L, -50L, -60L, -70L, -80L, -90L, -100L);
        ForkJoinSum forkJoinSum = new ForkJoinSum(testList);
        Long actual = forkJoinSum.compute();
        Assertions.assertEquals(-540, actual);
    }

    @Test
    void getSumDifferentElements_ok() {
        List<Long> testList = List.of(-20L, 30L, -40L, 50L, -60L, 70L, -80L, 90L, -100L);
        ForkJoinSum forkJoinSum = new ForkJoinSum(testList);
        Long actual = forkJoinSum.compute();
        Assertions.assertEquals(-60, actual);
    }
}
