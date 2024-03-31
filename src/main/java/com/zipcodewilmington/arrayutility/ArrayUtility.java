package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] arr;
    public ArrayUtility(T[] inputArray) {
        this.arr = inputArray;

    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        T[] newArr = mergeArrays(arrayToMerge);
        int counter = 0;
        for(Object s: newArr){
            if( s.equals(valueToEvaluate)) {
                counter ++;}
        }
        return counter;


    }

    public T getMostCommonFromMerge(T[] arrayToMerge) {
        T[] newArr = mergeArrays(arrayToMerge);
        HashSet<T> hs = new HashSet<>();//use HashSet to put the processed (unique) objects
        T mostCommon = null; //most common object
        int mcCount = 0; //times most common object is seen
        for(int i = 0; i< newArr.length; i++){
            if(!hs.contains(newArr[i])) {
                hs.add(newArr[i]);
                int count = 1;
                for (int j = i + 1; j < newArr.length; j++) {
                    if (Objects.equals(newArr[i], newArr[j])) {
                        count++;
                    }
                }
                if (count > mcCount) {
                    mcCount = count;
                    mostCommon = newArr[i];
                }
            }
        }

        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Objects.equals(arr[i], valueToEvaluate)) {
                count++;
            }
        }
            return count;
        }


        public T[] removeValue (T valueToRemove){

            ArrayList<T> list = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                if (!Objects.equals(arr[i], valueToRemove)) {
                    list.add(arr[i]);
                }
            }
            //Convert Arraylist to array of type T[].
            return list.toArray((T[]) Array.newInstance(valueToRemove.getClass(), list.size()));

        }


    private T[] mergeArrays(T[] objectArrayToAdd) {
       //Created new instance of array T[]  with the type the same as the first element of objectArrayToAdd
        T[] newArr = (T[]) Array.newInstance(objectArrayToAdd[0].getClass(), arr.length + objectArrayToAdd.length);
        for(int i = 0; i< arr.length; i++){
            newArr[i] = arr[i];
        }
        for(int i = 0; i< objectArrayToAdd.length; i++){
            newArr[i+ arr.length]= objectArrayToAdd[i];
        }

        return newArr;
    }
}
