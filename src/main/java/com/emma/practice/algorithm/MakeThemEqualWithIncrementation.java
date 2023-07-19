package com.emma.practice.algorithm;

import java.util.*;

public class MakeThemEqualWithIncrementation {
    //take K number from an array of numbers such that you minimize
    // the number of increments to make all the numbers equal
    // [5,3,10,5] K=2 correct answer=0
    // [3,1,9,100] K=3 correct answer=14
    private List<Integer> originalInts = Arrays.asList(new Integer[]{3,1,9,100});
    private Integer k=3;
    private List<Tuple> numberAndSmallestGaps = new ArrayList<Tuple>();
    public void execute() {
        //take each number on the list, then the  next k numbers and find increments
        for (int givenInt: originalInts) {
            List<Integer> smallestGaps = getSmallestGaps(givenInt, originalInts, k);
            Tuple thisTuple = new Tuple(givenInt, smallestGaps);
            numberAndSmallestGaps.add(thisTuple);
        }
        //merge and minimize List of tuples


    }

    private List getSmallestGaps(Integer givenNumber, List<Integer> originalInts, Integer k) {
        List<Integer> numbersWithSmallestGaps = originalInts.subList(0, k); //just with the first k numbers
        for (int i=k+1; i<originalInts.size();i++) {
            for(int j=0; j<numbersWithSmallestGaps.size();j++) {
                if(Math.abs(givenNumber-numbersWithSmallestGaps.get(j))>originalInts.get(i)) {
                    numbersWithSmallestGaps.set(j,originalInts.get(i));
                }
            }
        }
        return numbersWithSmallestGaps;
    }

    private class Tuple{
        Integer myNumber;
        List<Integer> smallestGapNumbers;

        public Tuple(Integer givenInt, List<Integer> smallestGaps) {
            this.myNumber = givenInt;
            this.smallestGapNumbers = smallestGaps;
        }

        public Integer getMyNumber() {
            return myNumber;
        }

        public void setMyNumber(Integer myNumber) {
            this.myNumber = myNumber;
        }

        public List<Integer> getSmallestGapNumbers() {
            return smallestGapNumbers;
        }

        public void setSmallestGapNumbers(List<Integer> smallestGapNumbers) {
            this.smallestGapNumbers = smallestGapNumbers;
        }
    }
}
