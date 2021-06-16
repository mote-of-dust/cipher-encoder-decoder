/* scrambleTest.java finialized on 06-16-2021 by Marc Casper
*
* A small pet project, essentially just making a bloated caesar cipher using the 
* ascii table. This is not to be taken as any sort of serious attempt at 
* cryptography, and it is not to be used in any circumstance to try and encrypt 
* any information. This process completely fails Kerckhoffs's principle, and just 
* as a caesar cipher is trivial to crack once you know its process, so too is this 
* programs process trivial to crack.
*
*
*/

import java.util.Random;
import java.util.Scanner;

public class scrambleTest
{
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);

        System.out.println("Input a string to be scrambled:");
        String input = scn.nextLine();

        char[] reverso = rever(input);
        char[] cissar = ceasar(reverso);
        byte[] nawmbers = bytconv(cissar);
        for(byte c: nawmbers)
        {
            System.out.print(c);//prints out first "letter" of the message
            Random dice = new Random();

            int num = dice.nextInt(2)+2;//rolls a die to decide how many numbers come after the printed letter
            for(int i = 1; i <= num; i++)
            {
                String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

                System.out.print(chars.charAt(dice.nextInt(chars.length())));
                //prints the correct amount of number of
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("This is a test. Break the code within 12 hours and win a prize :^)");

    }
    public static char[] rever(String start)
    {
        int i;
        int j = start.length()-1;
        char[] rev = new char[start.length()];

        if(start.length() % 2 == 0)
        {
            for(i = 0; i < start.length()/2; i++)
            {
                rev[i] = start.charAt(j);
                rev[j] = start.charAt(i);
                j -= 1;
            }
        }
        else
        {
            for(i = 0; i <= start.length()/2; i++)
            {
                rev[i] = start.charAt(j);
                rev[j] = start.charAt(i);
                j -= 1;
            }
        }
        return rev;
    }
    public static char[] ceasar(char[] rev)
    {
        String yosh = " ";
        for(char c: rev)//shifts each character by 2 ex a >> c and puts it in String yosh which starts with a space
        {
            c+=2;

            yosh += c;
        }

        for(int i = 1; i < yosh.length(); i++)//puts the shifted letters back into the original array, starting with the actual letters (forgoing the space at i=0)
        {
            rev[i-1] = yosh.charAt(i);
        }

        return rev;
    }
    public static byte[] bytconv(char[] input)
    {
        byte[] ayy =  new byte[input.length];
        for(int i=0; i< input.length; i++)
        {
            ayy[i] = (byte)input[i];
        }
        return ayy;
    }
}