package net.youngrok.codetests.programmers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/214288
public class DoughnutGraphTest {
    @Test
    public void test1() {
        int k = 3;
        int n = 5;
        int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
        int expectedResult = 25;
        int result = solution(k, n, reqs);
        Assertions.assertEquals(result, expectedResult);
    }

    @Test
    public void test2() {
        int k = 3;
        int n = 3;
        int[][] reqs = {{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2}, {65, 30, 1}, {70, 100, 2}};
        int expectedResult = 25;
        int result = solution(k, n, reqs);
        Assertions.assertEquals(result, expectedResult);
    }

    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        return answer;
    }

    private static final int ARRIVAL = 0;
    private static final int TIME = 1;
    private static final int JOB = 2;

    /**
     * @param mentoJobs mentoMap[n] = k
     * @param k        k
     * @param reqs     requs
     * @return waitingTimes[k]
     */
    public int[] calcWaitingTime(int k, int[] mentoJobs, final int[][] reqs) {
        int[] waitingTimes = new int[k];
        Arrays.fill(waitingTimes, 0);

        List<Queue<int[]>> waitingQueue = new ArrayList<>(k); // [req, arrival]
        for (int i = 0; i < k; i++) {
            waitingQueue.add(new LinkedList<>());
        }

        List<Integer> doneReqs = new ArrayList<>();

        final int MENTO_START = 0;
        final int MENTO_REQ = 1;
        final int MENTO_TIME = 2;
        int[][] mentoWorks = new int[mentoJobs.length][]; // [start, req, times]
        for (int i = 0; i < mentoWorks.length; i++) {
            mentoWorks[i] = new int[] {0, -1, 0};
        }

        for (int clock = 0; true; clock++) {

            // free mento
            for (int[] mentoWork : mentoWorks) {
                if (mentoWork[MENTO_REQ] != -1) {
                    if (clock >= mentoWork[MENTO_TIME] - mentoWork[MENTO_START]) {
                        doneReqs.add(mentoWork[MENTO_REQ]);
                        mentoWork[MENTO_REQ] = -1;
                    }
                }
            }

            if (doneReqs.size() == reqs.length) {
                break;
            }

            // find free mento
            int free_mento = -1;
            for (int i = 0; i < mentoJobs.length; i++) {
                if (mentoJobs[i] == req[JOB]) {
                    if (mentoWorks[i][MENTO_REQ] == -1) {
                        free_mento = i;
                        break;
                    }
                }
            }

            if (free_mento == -1) {
                continue;
            }

        }

        return waitingTimes;
    }
}

