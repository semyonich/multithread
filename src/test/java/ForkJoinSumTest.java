import com.multithread.ForkJoinSum;
import com.multithread.Util;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForkJoinSumTest {
    private static final int NUMBER_OF_VALUES = 1000_000;
    private static final int MAX_LIST_VALUE = 1;

    @Test
    void getSum_Ok() {
        List<Integer> firstList = Util.getIntList(NUMBER_OF_VALUES, MAX_LIST_VALUE);
        ForkJoinSum forkJoinSum = new ForkJoinSum(firstList);
        Long actual1 = forkJoinSum.compute();
        Assertions.assertEquals(1000_000, actual1);
        List<Integer> secondList = List.of(20, 30, 40, 50, 60, 70, 80, 90, 100);
        forkJoinSum = new ForkJoinSum(secondList);
        Long actual2 = forkJoinSum.compute();
        Assertions.assertEquals(540, actual2);
    }
}
