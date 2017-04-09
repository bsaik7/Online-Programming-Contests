import java.util.*;
import java.util.Map.Entry;

public class Bathroom_Stalls {

	public static void main(String[] args) 
	{
		Scanner in =new Scanner(System.in);
		//SortedSet set = new TreeSet();
		//ArrayList<Integer> set=new ArrayList<Integer>();
		
		int T=in.nextInt();
		int left[]=new int[T];
		int right[]=new int[T];
		for(int i=0;i<T;i++)
		{
			int n=in.nextInt();
			int k=in.nextInt();
			if(k==n)
			{
				left[i]=0;
				right[i]=0;
			}
			else if(k==1)
			{
				if(n%2==0)
				{
					left[i]=n/2;
					right[i]=n/2-1;
				}
				else
				{
					left[i]=n/2;
					right[i]=n/2;
				}
			}
			else
			{
				TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
				if(n%2==0)
				{
					tmap.put(n/2,1);
					tmap.put(n/2-1,1);
				}
				else
				{
					tmap.put(n/2,2);
					//tmap.add(n/2);
				}
			
				for(int j=2;j<=k-1;j++)
				{
				  //System.out.println(tmap.get(tmap.lastKey()));
					int l=tmap.lastKey();
					System.out.println(j+" "+l);
					//System.out.println(l/2+"--->>> "+tmap.get(l/2)+1);
					if(l%2==0 && l!=0)
					{
						//int p=tmap.get(l/2);
						//int p1=tmap.get(l/2);
						//int l1=l/2;
						//System.out.println(l/2+"--->>> "+tmap.get(l1)+1);
						if(tmap.containsKey(l/2))
							{
							tmap.put(l/2,(tmap.get(l/2))+1);
							//System.out.println(l/2+"--->>> "+tmap.get(l1)+1);
							} 
						else
							tmap.put(l/2,1);
						if(tmap.containsKey(l/2-1))
							tmap.put(l/2,tmap.get(l/2-1)+1);
						else
							tmap.put(l/2-1,1);
					}
					else
					{
						if(tmap.containsKey(l/2))
							tmap.put(l/2,tmap.get(l/2)+2);
						else
							tmap.put(l/2,2);
					}
					if(tmap.get(tmap.lastKey())>1)
					{
						tmap.put(l, tmap.get(tmap.lastKey())-1);
					}
					else
						tmap.remove(l);
					for(Entry<Integer, Integer> entry : tmap.entrySet()) 
						{
						  Integer key = entry.getKey();
						  Integer value = entry.getValue();

						  System.out.println(key + " => " + value);
						}
					System.out.println("======================================");
				}
				int m=tmap.lastKey();
				if(m%2==0 && m!=0)
				{
					left[i]=m/2;
					right[i]=m/2-1;
				}
				else
				{
					left[i]=m/2;
					right[i]=m/2;
				}
				tmap.clear();
			}
			
		}
		for(int i=0;i<T;i++)
		{
			System.out.println("Case #"+(i+1)+": "+left[i]+" "+right[i]);
		}
		
	}

}
