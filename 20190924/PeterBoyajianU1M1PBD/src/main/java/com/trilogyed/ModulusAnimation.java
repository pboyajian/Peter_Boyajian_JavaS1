package com.trilogyed;

public class ModulusAnimation
{
    public static void main( String[] args ) throws Exception
    {
        for ( int i=0; i<80; i++ )
        {
            if ( i%11 == 0 )
                System.out.print("0            \r");
            else if ( i%16 == 1 )
                System.out.print("00     \r");
            else if ( i%16 == 2 )
                System.out.print("000  \r");
            else if ( i%16 == 3 )
                System.out.print("0000\r");
            else if ( i%16 == 4 )
                System.out.print("00000\r");
            else if ( i%16 == 5 )
                System.out.print("000000 \r");
            else if ( i%16 == 6 )
                System.out.print("00000\r");
            else if ( i%16 == 7 )
                System.out.print("0000 \r");
            else if ( i%16 == 8 )
                System.out.print("000\r");
            else if ( i%16 == 9 )
                System.out.print("00\r");
            else if ( i%16 == 10 )
                System.out.print("0\r");

            Thread.sleep(250);
        }

    }
}
