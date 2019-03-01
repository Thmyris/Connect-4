package connect.pkg4;

/**
 *
 * @author Thmyris
 */



public class BoardInterface {
    public String [][] multiArray;

    public BoardInterface() {
        this.multiArray = new String[6][7];
    }
    //Burda 0,0 noktasi belirleyerek tahtayi cizmek epey hayat kolaylastirdi. MERKEZ NOKTASI
    //0,0 sol ust.
    
    
    public void print(){
        //---INIT printing of the actual board
        System.out.println(" 1   2   3   4   5   6   7");
        for(int i=0; i<6;i++){
            //System.out.print(i+1+" ");
            for(int j=0; j<7;j++){
                System.out.print("["+multiArray[i][j]+"]");
                System.out.print(" ");
            }
            System.out.println("");
        }
        //--end
    }
    
    
    
    public void welcomeScreen(){
        System.out.println("----------Hedef 4----------");
    }
    
    
    
    public void build(){
        //TODO tum bos matrisi(leri) olustur.
        //syntaxhint: int[] numbers = {100, 1, 42};

        //---INIT inside of the array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                multiArray[i][j]="-";
            }
        }
        //--end
        
/*        
        //DEBUG
        multiArray[3][1]="O";
        multiArray[4][2]="O";
        multiArray[0][3]="X";
        multiArray[3][4]="X";
        multiArray[2][5]="O";
        multiArray[0][0]="X";
        multiArray[1][0]="X";
        multiArray[2][0]="O";
        multiArray[3][0]="X";
        multiArray[4][0]="X";
        multiArray[5][0]="X";
        
*/      
    }
}

