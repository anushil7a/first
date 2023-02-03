// save this class in a file named E1.java
class E1
{
    // The main method will not be graded
    // You must use it for testing your code
    public static void main(String[] args)
    {
        ////////////////// testing approach 1 ///////////////////////
        // use the following code and run your program //
        // by providing the three numbers directly in the terminal //
        // e.g. C:\> java E1 34 2 50 //
        //int a = Integer.parseInt(args[0]); //
        //int b = Integer.parseInt(args[1]); //
        //int c = Integer.parseInt(args[2]); //
        //ystem.out.println("args: "+calculate(a,b,c));
        /*System.out.println("Straight flush: "+calculate(11,10,9));
        System.out.println("Three of a kind: "+calculate(6, 19, 32));
        System.out.println("Straight: "+calculate(48, 21, 7));//
        /////////////////////////////////////////////////////////////
        ////////////////// testing approach 2 ///////////////////////
        // call the calculate method with any arguments you want //
        // and print the returned value //
        System.out.println("Regular flush: "+calculate(12, 10, 6));
        //System.out.println("socrates: "+calculate(34, 2, 50));
        System.out.println("Two Pairs: "+calculate(15, 28, 38));
        //System.out.println("High cards: "+calculate(27, 11, 36));

        System.out.println("High cards: " + calculate(54,18,9));
        System.out.println("High cards: " + calculate(65, 19, 27));
        System.out.println("High cards: " + calculate(-8, 48, 10));
        System.out.println("High cards: " + calculate(0, 13, 1));
        System.out.println("High cards: " + calculate(90, 52, 6));
        System.out.println("Test case 6: " + calculate(13, 26, 40));
        System.out.println("Test case 7: " + calculate(13, 26, 52));
        System.out.println("works, supposed to return 7: " + calculate(52, 38, 24));
        System.out.println("error, supposed to return 7: " + calculate(39, 25, 11));
        System.out.println("error reverse, supposed to return 7: " + calculate(16, 30, 44));
        System.out.println("error reverse, supposed to return 7: " + calculate(44, 16, 30));
        System.out.println("Straight " + calculate(36, 24, 48));*/

        System.out.println("fixed, straight shuffle: " + calculate(15, 14, 16));
        System.out.println("error, Three of a kind: "+calculate(13, 39, 52));
        //
        /////////////////////////////////////////////////////////////
    }
    public static int calculate(int card1, int card2, int card3)
    {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        int last = 0;
//if the numbers given are 0 or under or 53+ return 0
        if (card1 <= 0 || card1 >= 53 || card2 <= 0 || card2 >= 53 || card3 <= 0 || card3 >= 53) {
            return last;
        }
        if (card1 <=13)
            s1 = "suit 1";
        else if (card1 <=26)
            s1 = "suit 2";
        else if (card1 <=39)
            s1 = "suit 3";
        else
            s1 = "suit 4";

        if (card2 <=13)
            s2 = "suit 1";
        else if (card2 <=26)
            s2 = "suit 2";
        else if (card2 <=39)
            s2 = "suit 3";
        else
            s2 = "suit 4";


        if (card3 <=13)
            s3 = "suit 1";
        else if (card3 <=26)
            s3 = "suit 2";
        else if (card3 <=39)
            s3 = "suit 3";
        else
            s3 = "suit 4";

        //System.out.println(s1);


        if (s1 == s2 && s2 == s3){
            //checks for straight flush
            //if they are the same suit and are in sequence they are a straight flush
            if((card1 + 1 == card2 && card2 + 1 == card3) ||
                    (card1 - 1 == card2 && card2 - 1 == card3) ||
            (card1 - 1 == card2 && card2 + 2 == card3) ||
                    (card1 + 2 == card2 && card2 - 1 == card3) ||
                    (card1 + 1 == card2 && card2 - 2 == card3) ||
                    (card1 - 2 == card2 && card2 + 1 == card3)){
                last = 10;
                return last;
            }
            //if it is not a straight flush but a regular flush it will return 5
            last = 5;
            return last;
        }


        //checks if the cards are three of a kind
        //if the remainders are equal, it is a three of a kind
        if (card1 % 13 == card2 % 13 && card2 % 13 == card3 % 13 && card1 % 13 == card3 % 13){
            last = 8;
            return last;
    }
        //check if it is a straight
        //if the remainder +-1 == other card numbers, it is a straight
        //if the number is in the end check if the card# -14 equals the other card and that card -14 equals the other cards
        //check this all the way and if it passes return 7
        if(((card1%13 + 1 == card2%13) && (card2%13 + 1 == card3%13)) ||
                ((card1%13 - 1 == card2%13) && (card2%13 - 1 == card3%13)) ||
                ((card1%13 + 1 == card2%13 && card2%13 - 2 == card3%13)) ||
                (card1%13 + 2 == card2%13 && card2%13 - 1 == card3%13) ||
                (card1%13 - 1 == card2%13 && card2%13 + 2 == card3%13)||
                ((card1%13 - 2 == card2%13 && card2%13 + 1 == card3%13))||//have to add all cases
        ((card1-14 == card2)&& card2-14 == card3) || ((card1+14 == card2)&& card2+14 == card3)
        || ((card1-14 == card2)&& card2+28 == card3)|| ((card1+28 == card2)&& card2-14 == card3)
        || ((card1+14 == card2)&& card2-28 == card3) || ((card1-28 == card2)&& card2+14 == card3)){
            last = 7;
            return last;
        }

        //checks if the cards are pairs
        //if the 2 cards remainders are equal they are pairs
        if (card1 % 13 == card2 % 13 || card2 % 13 == card3 % 13 || card1 % 13 == card3 % 13){
            last = 3;
            return last;
        }

        return 1;
    }
}
