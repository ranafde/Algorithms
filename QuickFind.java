import java.io.BufferedReader;
import java.io.InputStreamReader;



public class QuickFind {

	private int[] id;
	
	public QuickFind(int N){
		id = new int[N];
		for(int i=0; i<N; ++i)
			id[i] = i;
	}
	
	public boolean find(int p, int q){
		return (id[p] == id[q]);		
	}
	
	public void union(int p, int q){
		int pid = id[p];
		int qid = id[q];
		for(int i=0; i<id.length; ++i)
			if(id[i] == pid)
				id[i] = qid;
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
		QuickFind qf = new QuickFind(Integer.parseInt(in));
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
