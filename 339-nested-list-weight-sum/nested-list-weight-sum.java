/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
         int[] ret = new int[1]; 
         for(int i = 0; i < nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                ret[0] += nestedList.get(i).getInteger();
            }
            else {
                dfs(nestedList.get(i), 2, ret);
            }
         }
         return ret[0];
    }

    public void dfs(NestedInteger nl, int level, int[] ret){
        if(nl.isInteger()){
            ret[0] += nl.getInteger() * level;
            return;
        }

        int len = nl.getList().size();
        for(int i = 0; i < len; i++){
            if(nl.getList().get(i).isInteger()){
                ret[0] += nl.getList().get(i).getInteger() * level;
            }
            else {
                dfs(nl.getList().get(i), level + 1, ret);
            }
        }
    }
}