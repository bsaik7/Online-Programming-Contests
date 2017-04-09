import java.util.Scanner;

public class Pan_Cakes 
{
	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int T=in.nextInt();
		int flip[]=new int[T];
		for(int i=0;i<T;i++)
		{
			String s=in.next();
			int k=in.nextInt();
			flip[i]=0;
			while(true)
			{
				int p=s.indexOf('-');
				if(p==-1)
					break;
				else if(s.length()-(p+1)<(k-1))
				{
					flip[i]=-1;
					break;
				}
				else
				{
					//System.out.println(p+" "+s.length());
					flip[i]++;
					char a[]=s.toCharArray();
					a[p]='+';
					p++;
					for(int j=0;j<k-1;j++)
					{
						if(a[p]=='+')
						{
							a[p]='-';
						}
						else
						{
							a[p]='+';
						}
						p++;
					}
					String s1=new String(a);
					s=s1;
					//System.out.println(s);
				}
				//System.out.println(p);
			}
		}
		for(int i=0;i<T;i++)
		{
			if(flip[i]==-1)
				System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
			else
				System.out.println("Case #"+(i+1)+": "+flip[i]);
		}
	}
}