package com.codewithmosh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTableExercices {

    public int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for(var number : numbers) {
            var count  = map.getOrDefault(number, 0);
            map.put(number, count + 1);
        }

        int max = -1;
        int result = numbers[0];
        for(var item : map.entrySet()) {
            if(item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }

    public int countPairsWithDiff(int numbers[], int k) {
        int pairs = 0;
        Set<Integer> set = new HashSet<>();
        for(var number : numbers) {
            set.add(number);
        }

        for(var number : numbers) {
            if(set.contains(number - k)) {
                pairs++;
            }
            if(set.contains(number + k)) {
                pairs++;
            }
            set.remove(number);
        }
        return pairs;
    }

    public int[] twoSum(int[] numbers, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            int complement = k - numbers[i];
            if(map.containsValue(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(i, numbers[i]);
        }
        return null;
    }
}
