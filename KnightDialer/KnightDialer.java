public class KnightDialer{
  public static void main(String[] args){
    KnightDialer kD = new KnightDialer();
    System.out.println(kD(3));
  }
  
  public int knightDialer(int moves){
    int[][] validMoves = new int[10][];
    knightMoveInitializer(validMoves);
    //Assuming no n=0 case
    int knightLocation = 1;
    if(moves == 1){
      return 1;
    }
    int sum = 0;
    int stopPoint = moves - 1; 
    ArrayList<Integer> locations = new ArrayList<>();
    knightDialerInternal(knightLocation, validMoves, stopPoint, locations);
    for(int i = 0; i < locations.size(); i++) {
    	sum += validMoves[locations.get(i)].length;
    }
    return sum;    
  }
  
  public static void knightDialerInternal(int loc, int[][] validMoves,
              int stopPoint, ArrayList<Integer> locations){
    if(stopPoint == 1){
      for(int i = 0; i < validMoves[loc].length; i++) {
    	  locations.add(validMoves[loc][i]);
      }
      return;
    }
    for(int i = 0; i < validMoves[loc].length; i++){
      knightDialerInternal(validMoves[loc][i], validMoves, stopPoint - 1, locations);
    }
  }

  //ArrayList may not be initialized, might give error
  private void knightMoveInitializer(int[][] validMoves){
    for(int i = 0; i < validMoves.length; i++){
      switch(i){
        case 0: validMoves[i] = new int[2];
                validMoves[i][0] = 4;
                validMoves[i][1] = 6;
                break;
        case 1: validMoves[i] = new int[2];
                validMoves[i][0] = 6;
                validMoves[i][1] = 8;
                break;
        case 2: validMoves[i] = new int[2];
                validMoves[i][0] = 7;
                validMoves[i][1] = 9;
                break;
        case 3: validMoves[i] = new int[2];
                validMoves[i][0] = 4;
                validMoves[i][1] = 8;
                break;
        case 4: validMoves[i] = new int[3];
                validMoves[i][0] = 3;
                validMoves[i][1] = 9;
                validMoves[i][2] = 0;
                break;
        case 6: validMoves[i] = new int[3];
                validMoves[i][0] = 1;
                validMoves[i][1] = 7;
                validMoves[i][2] = 0;
                break;
        case 7: validMoves[i] = new int[2];
                validMoves[i][0] = 2;
                validMoves[i][1] = 6;
                break;
        case 8: validMoves[i] = new int[2];
                validMoves[i][0] = 1;
                validMoves[i][1] = 3;
                break;
        case 9: validMoves[i] = new int[2];
                validMoves[i][0] = 2;
                validMoves[i][1] = 4;
                break;
      }
    }
  }
}
