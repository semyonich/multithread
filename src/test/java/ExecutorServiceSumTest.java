import com.multithread.ExecutorServiceSum;
import com.multithread.Util;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExecutorServiceSumTest {
    private static ExecutorServiceSum executorServiceSum;
    private static final int THREADS_NUMBER_1 = 10;
    private static final int THREADS_NUMBER_2 = 4;
    private static final int NUMBER_OF_VALUES = 1000_000;
    private static final int MAX_LIST_VALUE = 1;

    @BeforeAll
    public static void beforeAll() {
        executorServiceSum = new ExecutorServiceSum();
    }

    @Test
    void getSum_Ok() {
        List<Integer> firstList = Util.getIntList(NUMBER_OF_VALUES, MAX_LIST_VALUE);
        executorServiceSum.setIntList(firstList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_1);
        Long actual1 = executorServiceSum.calculateSum();
        Assertions.assertEquals(1000_000, actual1);
        List<Integer> secondList = List.of(20, 30, 40, 50, 60, 70, 80, 90, 100);
        executorServiceSum.setIntList(secondList);
        executorServiceSum.setNumberOfThreads(THREADS_NUMBER_2);
        Long actual2 = executorServiceSum.calculateSum();
        Assertions.assertEquals(540, actual2);
    }
}
