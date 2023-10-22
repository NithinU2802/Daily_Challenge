/******************************************************************************

    Calculating Mod Inverse for the given numbers

*******************************************************************************/

public class ModInverse
{
    
    static public long modInverse(int a, int m) {
    
    for (int i = 1; i < m; i++)
        if ((a*i)%m== 1)
            return i;
    return 1;
}
    
	public static void main(String[] args) {
	int a=x.nextInt(),b=x.nextInt();
	System.out.println(modInverse(a,b));
	}
}
