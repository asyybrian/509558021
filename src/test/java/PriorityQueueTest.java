package main.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;





public class PriorityQueueTest  {
    static Stream<Arguments> test_provide(){
        return Stream.of(
                Arguments.of(new int[]{3,1,2}, new int[]{1,2,3}),
                Arguments.of(new int[]{-3,-1,-2,5},new int[]{-3,-2,-1,5} ),
                Arguments.of(new int[]{3,-2,-5,-1,2},new int[]{-5,-2,-1,2,3} ),
                Arguments.of(new int[]{-3,1,11,0,9,3},new int[]{-3,0,1,3,9,11} ),
                Arguments.of(new int[]{3,7,2,-1,-2},new int[]{-2,-1,2,3,7} )
        );
    }


    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("test_provide")
    public void Priority_run(int[] random_arrary, int[] correct_answer){
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int[] result = new int[random_arrary.length];

        //todo add
        for (int i=0;i < random_arrary.length; i++) {
            test.add(random_arrary[i]);
            //System.out.print(random_arrary[i] + " \n");
        }


        //todo get result
        for (int i=0;i < random_arrary.length; i++) {
            result[i] = test.poll();
            //System.out.print(result[i] + " \n");
        }

        assertArrayEquals(correct_answer,result);

    }

    //TODO 3 expected

    @Test
    public void Exception_null_add() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PriorityQueue().add(null);
        });

    }


    @Test
    public void Exception_null_poll() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            Priority_run(null,null);
        });

    }



    @Test
    public void Exception_Fake() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PriorityQueue(0);
        });

    }

}
