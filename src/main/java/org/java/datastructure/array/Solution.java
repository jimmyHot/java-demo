package org.java.datastructure.array;

public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null){
            return false;
        }
        if(array[0][0] > target){
            return false;
        }
        return FindDetail(target,array,array.length-1,0);
    }

    private boolean FindDetail(int target, int [][] array,int pointx,int pointy){
        if(pointx<0 || pointy>array[0].length-1){
            return false;
        }
        if(array[pointx][pointy] == target){
            return true;
        }
        if(array[pointx][pointy] < target){
            return FindDetail(target,array,pointx,pointy+1);
        }else{
            return FindDetail(target,array,pointx-1,pointy);
        }
    }
}
