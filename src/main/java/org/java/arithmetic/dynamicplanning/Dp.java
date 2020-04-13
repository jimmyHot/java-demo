package org.java.arithmetic.dynamicplanning;

/**
 * 动态规划
 */
public class Dp {


    /**
     * 问题描述：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param n n级台阶
     * 思路：
     *  1·定义数组元素的含义，当青蛙跳上n级台阶总共有dp[n]种跳法
     *  2·找出数组元素间的关系：青蛙跳到n级台阶有两种方式，从n-1或者n-2台阶上跳，所以，dp[n]=dp[n-1]+dp[n-2];
     *  3·通过数学归纳法找出初始值 d[1]=1;d[2]=2;
     */
    public int jumpNum(int n){
        if(n<0){
            return 0;
        }
        if(n==0 || n==1 || n==2){
            return n;
        }
        //设置初始值
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角,机器人每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角.问总共有多少条不同的路径？
     * 思路：
     *  1·定义数组元素的含义，dp[m-1][n-1]=表示机器人走到终点的总路径数
     *  2·找出数组元素间的关系：机器人走到终点有两种方式，从dp[m-1][n-2] 或者dp[m-2][n-1] 移动，
     *    所以 dp[m-1][n-1]=dp[m-1][n-2] + dp[m-2][n-1]
     *  3·通过数学归纳法找出初始值 考虑m/n=0情况，即dp[0][0,1...n]=1;dp[0,1...m][0]=1;
     * @return
     */
    public int uniquePaths(int m ,int n){
        if(m<0 || n<0){
            return 0;
        }
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：插入一个字符 删除一个字符 替换一个字符
     * @param word1
     * @param word2
     * 思路：
     *  1·定义数组元素的含义，dp[m][n]=表示 将 word1 转换成 word2 所使用的最少操作数
     *  2·找出数组元素间的关系：
     *      2·1 如果word1[m]=word2[n],则dp[m][n]=dp[m-1][n-1]
     *      2·2 如果word1[m]!=word2[n],从下边三种情况下求min
     *          2·2·1 如果插入一个字符 dp[m][n]=dp[m][n-1]+1
     *          2·2·2 如果删除一个字符 dp[m][n]=dp[m-1][n]+1
     *          2·2·3 如果替换一个字符 dp[m][n]=dp[m-1][n-1]+1
     *  3·通过数学归纳法找出初始值 即dp[0][0,1...n]=n;dp[0,1...m][0]=m;
     *
     *  horse ros
     */
    public int minCount(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] db=new int[m+1][n+1];
        for (int i=0;i<=m;i++){
            db[i][0]=i;
        }
        for (int j=0;j<=n;j++){
            db[0][j]=j;
        }
        for(int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    db[i][j]=db[i-1][j-1];
                }else {
                    db[i][j]=Math.min(Math.min(db[i][j-1]+1,db[i-1][j-1]+1),db[i-1][j]+1);
                }
            }
        }
        return db[m][n];
    }
}
