package connect.pkg4;

import java.util.Scanner;

/**
 *
 * @author Thmyris
 */
public class GameLogic {

    public boolean isRunning = true;
    public static int turn = 2; //1 => 1.oyuncu(O) & 2 => 2.oyuncu(X)
    BoardInterface board1 = new BoardInterface();
    public int chosen;
    public int oCounter = 0;
    public int xCounter = 0;
    
    
    public void startGame() {
        while(true){
            board1.welcomeScreen();
            board1.build();
            board1.print();
            GameLoop();
            playAgain();
        }
    }
    
    public void playAgain(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Tekrar oynamak isterseniz Enter'a basin...");
        reader.nextLine();
        isRunning=true;
    }

    public void GameLoop() {
        while (isRunning) {
            chosen = getInput();
            dropCheckers();
            board1.print();
            checkWinCondition();
            swapTurns();
        }
    }

    private void swapTurns(){
        if (turn == 1) {
            turn = 2;
        } else {
            turn = 1;
        }
    }

    public void dropCheckers() {
        int suitableRow = lastEmptyHole();
        if (turn == 1) {
            board1.multiArray[suitableRow][chosen] = "O";
            oCounter++;
        } else {
            board1.multiArray[suitableRow][chosen] = "X";
            xCounter++;
        }
    }

    public void checkWinCondition() {
        //geldik en kolay metoda :)
        int winnerVertical, winnerHorizontal, winnerCrossSE, winnerCrossSW; //0: nobody won //1: 1.oyuncu(O) kazandi //2: 2.oyuncu(X) kazandi
///*        
        winnerVertical = verticalCheck();
        winnerHorizontal = horizontalCheck();
        winnerCrossSE = crossCheckSE();
        winnerCrossSW = crossCheckSW();
/*
        if (winnerVertical != 0 || winnerHorizontal != 0 || winnerCrossSE != 0 || winnerCrossSW !=0) {//DEBUG
            System.out.println("winne: " + winnerVertical + winnerHorizontal + winnerCrossSE + winnerCrossSW);
        }
*/        
        if (winnerVertical == 1 || winnerHorizontal == 1 || winnerCrossSE == 1 || winnerCrossSW ==1){
            System.out.println("1. oyuncu (O) oyunu kazandi!");
            isRunning=false;
        }
        else if(winnerVertical == 2 || winnerHorizontal == 2 || winnerCrossSE == 2 || winnerCrossSW ==2) {
            System.out.println("2. oyuncu (X) oyunu kazandi!");
            isRunning=false;
        }
//*/        

        //---berabere kalma kontrolu //bu kontrol metodun sonuna konmak zorunda cunku berabere kalmadan once bir oyuncu oynu kazanabilir
        int sum = oCounter + xCounter;
        if (sum == 42) {
            System.out.println("Berabere kaldınız.");
            isRunning = false;
        }
        //---berabere kalma kontrolu

    }

///*
    //BU ALTTAKI KONTROLLER SON ATILAN TASIN KONUMUNA GORE KONTROL EDIYOR. (hic degilse vertical oyle :>)
    private int verticalCheck() { //return 0: nobody won yet //returns 1: 1.oyuncu(O) kazandi //returns 2: 2.oyuncu(X) kazandi //checks from down upwards
        //int lastFullHole; //scrapped usage of this variable
        //int xVerticalWinCounter = 0; //scrapped usage of this variable
        //int oVerticalWinCounter = 0; //scrapped usage of this variable

        for (int a = 5; a > 2; a--) {
            if (board1.multiArray[a][chosen].equals("X")) {
                if (board1.multiArray[a - 1][chosen].equals("X")) {
                    if (board1.multiArray[a - 2][chosen].equals("X")) {
                        if (board1.multiArray[a - 3][chosen].equals("X")) {
                            return 2;
                        }
                    }
                }
            } else if (board1.multiArray[a][chosen].equals("O")) {
                if (board1.multiArray[a - 1][chosen].equals("O")) {
                    if (board1.multiArray[a - 2][chosen].equals("O")) {
                        if (board1.multiArray[a - 3][chosen].equals("O")) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }

    private int horizontalCheck() { //return 0: nobody won //returns 1: 1.oyuncu(O) kazandi //returns 2: 2.oyuncu(X) kazandi //Screw trying to optimize performance in a spaghetti code like this. This method alone took years to write, scrapped most of my tries. Went with the most brute force option.
        for(int i=5;i>-1;i--){ //i is row, since i messed up the last(non-empty)EmptyHole we are checking every row, albeit in a rather fast way.
            for(int j=0;j<4;j++){ //j is column, you only need to check 4 columns because you already check if there are 4 in a horizontal patter towards the right. 
                if (!board1.multiArray[i][j].contains("-")){
                    if(board1.multiArray[i][j].contains("X") && board1.multiArray[i][j+1].contains("X") && board1.multiArray[i][j+2].contains("X") && board1.multiArray[i][j+3].contains("X")){
                        return 2;
                    } else if (board1.multiArray[i][j].contains("O") && board1.multiArray[i][j+1].contains("O") && board1.multiArray[i][j+2].contains("O") && board1.multiArray[i][j+3].contains("O")){
                        return 1;
                    }
                }
            }   
        }
        return 0;
    }

    private int crossCheckSE() {//SE: south east, checking blocks @ NW        //return 0: nobody won //returns 1: 1.oyuncu(O) kazandi //returns 2: 2.oyuncu(X) kazandi //sag alta dogru kontrol edecek dolayisiyla sol ustte kucuk bir dikdortgende gezinecegiz. //fikir @cansozbir'den yeterince optimal, dusunup yazmasi kolay
        //NOTE: Burda 0,0 noktasi belirleyerek tahtayi cizmek epey hayat kolaylastirdi. MERKEZ NOKTASI
        for (int i=2;i>-1;i--){
            for(int j=0; j<4; j++){
                if (!board1.multiArray[i][j].contains("-")){
                    if(board1.multiArray[i][j].contains("X") && board1.multiArray[i+1][j+1].contains("X") && board1.multiArray[i+2][j+2].contains("X") && board1.multiArray[i+3][j+3].contains("X")){
                        return 2;
                    }else if (board1.multiArray[i][j].contains("O") && board1.multiArray[i+1][j+1].contains("O") && board1.multiArray[i+2][j+2].contains("O") && board1.multiArray[i+3][j+3].contains("O")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
    
    private int crossCheckSW(){
        for (int i=0; i<3;i++){
            for(int j=3; j<7;j++){
                if(!board1.multiArray[i][j].contains("-")){
                    if(board1.multiArray[i][j].contains("X") && board1.multiArray[i+1][j-1].contains("X") && board1.multiArray[i+2][j-2].contains("X") && board1.multiArray[i+3][j-3].contains("X")){
                        return 2;
                    }else if(board1.multiArray[i][j].contains("O") && board1.multiArray[i+1][j-1].contains("O") && board1.multiArray[i+2][j-2].contains("O") && board1.multiArray[i+3][j-3].contains("O")){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

//*/
    public int lastEmptyHole() { //this will be useful for checking win conditions
        while (true) {
            for (int i = 5; i > -1; i--) {
                //System.out.println("for calisma sayisi"); //DEBUG
                if (board1.multiArray[i][chosen].equals("-")) {
                    //System.out.println(i); //DEBUG
                    return i;
                }
            }
            System.out.print("O sütun dolu. Lütfen başka bir sütun seçiniz. "); //bu 2 satir basima cok bela acti, bir dahakine bir metod bir is yapsin, O KADAR. KONTROLLERI FARKLI YERLERDE YAP
            chosen = getInput();                                                
        }
    }

    public static int getInput() {
        Scanner reader = new Scanner(System.in);
        if(turn == 1){
            System.out.print("Oyuncu " + turn + " (O), ");
        }else{
            System.out.print("Oyuncu " + turn + " (X), ");
        }
        System.out.print("pulunuzu hangi kutucuğa atacağınızı seçiniz: ");

        while (true) {
            String x = reader.nextLine();
            if (x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7")) { //TODO can use regular expression (.matches("x|y|z"))here instead of multiple ORs
                return Integer.parseInt(x) - 1; //chosen id icin kullanima uygun hale getirilyior
            } else {
                System.out.print("Lütfen 1-7 arasında bir sayı giriniz: ");
            }
        }

    }

}
