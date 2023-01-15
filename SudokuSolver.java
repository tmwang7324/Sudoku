
public class SudokuSolver {
    
        public static final int num_rows = 9;
        public static final int num_columns = 9;
        public static final int min_num = 1;
        public static final int max_num = 9;
        public static final int null_value = 0;
        public static boolean checkConstraints(int [][] board, int row, int col, int val)
        {
            return (rConst(board, row, val) && cConst(board, col, val) && subsecConst(board, row, col, val));
        }
        public static boolean rConst(int [][] board, int row, int val)
        {
            for(int a = 0; a < num_columns; a++)
            {	
                
                if (board[row][a] == val){
                    return false;
                }
                
            }
            return true;
        }
        public static boolean cConst(int [][] board, int col, int val)
        {
            for(int b = 0; b < num_rows; b++)
            {	
                if(board[b][col] == val)
                    return false;
                
            }
            return true;
        }
        
        public static boolean subsecConst(int [][] board, int row,  int col, int val)
        {
            int beginningRowIndex = row - row % 3;
            int beginningColIndex = col - col % 3;
            for(int c = 0; c <= 2; c++)
            {	
                for(int d = 0; d < 3; d++)
                {	
                    if(board[beginningRowIndex + c][beginningColIndex + d] == val)
                    {	
                        return false;
                    }
                }
            }
            return true;
        }
        public static boolean solveBoard(int[][] board)
        {
        
            for(int r = 0; r < num_rows; r++)
            {
                for(int c = 0; c < num_columns; c++)
                {	
                    
                    if(board[r][c] == null_value)
                    {	 
                        for(int i = min_num; i <= max_num; i++)
                        {	
                                                                                                                                                                        
                            if(checkConstraints(board, r, c, i))
                            {	
                                
                                board[r][c] = i;
                                            
                                if(solveBoard(board))
                                {		
                                    return true;
                                } else
                                    board[r][c] = null_value;		
                                          
                            }				
                                    
                        }
                        return false;		
                    }
                 }
            }
            return true;
            
        }
        public static void printBoard(int [][] board)
        {
            for(int x = 0; x < num_rows; x++)
            {	
                for(int y = 0; y < num_columns; y++)
                {	
                    System.out.print(board[x][y] + " ");
                }
                System.out.println();
            }
        }
        public static void main(String [] args)
        {
            int[][] board = {
                    { 0, 0, 0, 6, 0, 0, 4, 0, 0 },
                    { 7, 0, 0, 0, 0, 3, 6, 0, 0 },
                    { 0, 0, 0, 0, 9, 1, 0, 8, 0 },
                    { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 5, 0, 1, 8, 0, 0, 0, 3 },
                    { 0, 5, 0, 3, 0, 6, 0, 4, 5 },
                    { 0, 4, 0, 2, 0, 0, 0, 6, 0 },
                    { 9, 0, 3, 0, 0, 0, 0, 0, 0 },
                    { 0, 2, 0, 0, 0, 0, 1, 0, 0 }
        };
            boolean b = (solveBoard(board));
                
            if(b)
                printBoard(board);
            else
                System.out.println("No solutions found");
        }
        
    }
    
