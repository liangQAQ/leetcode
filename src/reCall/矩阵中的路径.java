package reCall;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 例图，在下面的 3×4 的矩阵中包含单词 'ABCCED'（单词中的字母已标出）。
 *
 * 示例 1：
 * 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [['a','b'],['c','d']], word = 'abcd'
 * 输出：false
 *
 */
public class 矩阵中的路径 {
    public static boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(help(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean help(char[][] board, String word,int i,int j,int index) {
        System.out.println("i="+i+",j="+j+" || index="+index);
        //边界  剪枝(返回false)
        if( i<0 || j<0 || i>=board.length || j>=board[0].length ){
            return false;
        }
        if(board[i][j] == '#'){//结束条件
            return false;
        }
        if(word.charAt(index) == board[i][j]){
            if(index == word.length()-1){//结束条件
                return true;
            }
            //记录走过的路
            board[i][j] = '#';
            //下一步的上下左右四个方向
            return help(board,word,++i,j,++index)||help(board,word,i,++j,++index)||help(board,word,--i,j,++index)||help(board,word,i,--j,++index);
        }else{
            return false;//错误的路径 剪枝(返回false)
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
