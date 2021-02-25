import com.multithread.ExecutorServiceSum;
import com.multithread.ListProducer;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExecutorServiceSumTest {
    private static ExecutorServiceSum executorServiceSum;
    private static final int THREADS_NUMBER_1 = 8;
    private static final int THREADS_NUMBER_2 = 4;
    private static final int NUMBER_OF_VALUES = 1000_000;
    private static final int LIST_MAX_VALUE = 1;

    @BeforeAll
    public static void beforeAll() {
        executorServiceSum = new ExecutorServiceSum();
    }

    @Test
    void getSumLargeArray_ok() {
        List<Long> testList = ListProducer.getLongList(NUMBER_OF_VALUES, LIST_MAX_VALUE);
        executorServiceSum.setLongList(testList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_1);
        Long actual1 = executorServiceSum.calculateSum();
        Assertions.assertEquals(1000_000, actual1);
    }

    @Test
    void getSumPositiveElements_ok() {
        List<Long> testList = List.of(20L, 30L, 40L, 50L, 60L, 70L, 80L, 90L, 100L);
        executorServiceSum.setLongList(testList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_2);
        Long actual2 = executorServiceSum.calculateSum();
        Assertions.assertEquals(540, actual2);
    }

    @Test
    void getSumNegativeElements_ok() {
        List<Long> testList = List.of(-20L, -30L, -40L, -50L, -60L, -70L, -80L, -90L, -100L);
        executorServiceSum.setLongList(testList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_2);
        Long actual2 = executorServiceSum.calculateSum();
        Assertions.assertEquals(-540, actual2);
    }

    @Test
    void getSumDifferentElements_ok() {
        List<Long> testList = List.of(-20L, 30L, -40L, 50L, -60L, 70L, -80L, 90L, -100L);
        executorServiceSum.setLongList(testList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_2);
        Long actual2 = executorServiceSum.calculateSum();
        Assertions.assertEquals(-60, actual2);
    }
}
