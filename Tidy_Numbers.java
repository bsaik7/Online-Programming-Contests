import java.util.Scanner;

public class Tidy_Numbers 
{
	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int T=in.nextInt();
		long result[]=new long[T];
		for(int i=0;i<T;i++)
		{
			long n=in.nextLong();
			while(true)
			{
				long N=n;
				int a=(int) (N%10);
				//System.out.println(a);
				N=N/10;
				//System.out.println(N);
				while(N!=0)
				{
					if(a<N%10)
						break;
					a=(int) (N%10);
					//System.out.println(a);
					N=N/10;
					//System.out.println(N);
				}
				if(N==0)
				{
					result[i]=n;
					break;
				}
				else
					n=n-1;
			}
		}
		for(int i=0;i<T;i++)
		{
			System.out.println("Case #"+(i+1)+": "+result[i]);
		}
	}
}