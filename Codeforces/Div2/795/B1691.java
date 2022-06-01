import java.util.*;
import java.io.*;
public class B1691{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			Map<Integer,ArrayList<Integer>> map = new HashMap<>();
			for(int i=1;i<=n;i++){
				int num = fs.nextInt();
				if(map.get(num)==null){
					ArrayList<Integer> li = new ArrayList<>();
					li.add(i);
					map.put(num,li);
				}
				else
					map.get(num).add(i);
			}
			int res = 1;
			int cp[] = new int[n+1];
			for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
				int key = entry.getKey();
				ArrayList<Integer> li = entry.getValue();
				if(li.size()==1){
					res = -1;
					break;
				}
				else{
					int id = li.get(0);
					for(int i=1;i<li.size();i++){
						cp[id] = li.get(i);
						id = cp[id];
					}
					cp[id] = li.get(0);
				}
			}
			if(res==-1)
			out.println(res);
			else{
				for(int i=1;i<=n;i++){
					out.print(cp[i]+" ");
				}
				out.println();
			}
		}
		out.close();
	}
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}