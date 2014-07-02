import java.io.BufferedReader;
import java.io.InputStreamReader;



public class QuickUnionWeighted {

	private int[] id, size;
	
	public QuickUnionWeighted(int N){
		id = new int[N];
		size = new int[N];
		for(int i=0; i<N; ++i){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int p){
		while(id[p]!=p)
			p = id[p];
		return p;	
	}
	
	public boolean find(int p, int q){
		return (root(p) == root(q));		
	}
	
	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		if (i == j) 
			return;
		else if(size[j] > size[i]){
			id[i] = j;
			size[j] += size[i];
		}
		else{
			id[j] = i;
			size[i] += size[j];
		}
		
	}
	
	public void display(){
		System.out.println();
		for(int i=0; i<id.length; i++)
			System.out.print(id[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String in = "";
		in = bf.readLine();	
		QuickUnionWeighted qf = new QuickUnionWeighted(Integer.parseInt(in));
		int res;
		
		while(true){
			System.out.println("1. Union \n2. Find \n3. Display \n4. Exit");
			in = bf.readLine();
			res = Integer.parseInt(in);
			
			if(res == 1){
				int p, q;
				System.out.println("\n Union, Enter p and q:");
				in = bf.readLine();
				p = Integer.parseInt(in);
				in = bf.readLine();
				q = Integer.parseInt(in);
				qf.union(p, q);
			}
			
			else if(res == 2){
				int p, q;
				System.out.println("\n Find, Enter p and q:");
				in = bf.readLine();
				p = Integer.parseInt(in);
				in = bf.readLine();
				q = Integer.parseInt(in);
				qf.find(p, q);
			}
			
			else if(res == 3){
				qf.display();
			}
			
			else if(res == 4){
				break;
			}
		}
		
	}
}



