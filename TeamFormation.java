import java.util.Scanner;
import java.util.TreeMap;

public class TeamFormation {

	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		int T=in.nextInt();
		for (int i=1;i<=T;i++)
		{
			int n=in.nextInt();
			if(n!=0)
			{
			TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
			for(int j=0;j<n;j++)
			{
				int x=in.nextInt();
				if(!tmap.containsKey(x))
				{
					tmap.put(x,1);
				}
				else
				{
					tmap.put(x,(tmap.get(x))+1);
					//System.out.println(x);
				}
					
			}
			
			int min=Integer.MAX_VALUE;
			while(tmap.size()!=0)
			{
				int c=0;
				int h=tmap.lastKey();
				while(tmap.containsKey(h))
				{
					c++;
					//System.out.println("SAI"+c);
					if(tmap.get(h)>1)
					{
						tmap.put(h, (tmap.get(h))-1);
					}
					else
						tmap.remove(h);
					h=h-1;
					//System.out.println(tmap.containsKey(h)+" "+h);
				}
			//	System.out.println(c);
				if(min>c)
					min=c;
			}
			System.out.println(min);
			tmap.clear();
		}
			else
				System.out.println(0);
	
		}
	}

}
