class NumMatrix {

    int[][] presum; 
    public NumMatrix(int[][] matrix) {
        
        //first row and col are all 0 for presum matrix
        int r = matrix.length+1;
        int c = matrix[0].length+1;
        presum = new int[r][c];
        
        //populate presum
        for(int i =1; i< presum.length; i++){
            for(int j =1; j<presum[0].length; j++){
                presum[i][j]=presum[i-1][j]+presum[i][j-1]+matrix[i-1][j-1]-presum[i-1][j-1];
            }
        }            
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        //match the presum matrix index
        row1++;
        col1++;
        row2++;
        col2++;
        return presum[row2][col2]-presum[row2][col1-1]-presum[row1-1][col2]+presum[row1-1][col1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */