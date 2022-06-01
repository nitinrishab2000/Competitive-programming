import java.util.*;
import java.io.*;
public class C1691{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			String s = fs.next();
			char ch[] = s.toCharArray();
			int co = 0;
			int id1 = -1;
			int id2 = -1;
			if(ch[0]=='1'){
				id1 = 0;
				co+=1;
			}
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1;i<n;i++){
				int x = ch[i-1]-'0';
				int y = ch[i]-'0';
				x*=10;
				x+=y;	
				list.add(x);

				if(ch[i]=='1'){
					if(co==0){
						id1 = i;
					}
					else{
						id2 = i;
					}
					co+=1;
				}
			}
			int ans= 0;
			for(Integer p : list){
				ans+=p;
			}
			if(co==n){

			}
			else if(co==1){
				if(ch[0]=='1' || ch[n-1]=='1'){
					if(ch[0]=='1'){
						if((n-1)<=k){
							ans=1;
						}
					}
				}
				else{
					if((n-1-id1)<=k){
						ans-=10;
					}
					else if((id1)<=k){
						ans-=1;
					}
				}
			}
			else if(co>=2){
				if(ch[n-1]=='0'){
					if((n-1-id2)<=k){
						ans-=10;
						k-=(n-1-id2);
					}
				}
				if(ch[0]=='0'){
					if(id1<=k){
						ans-=1;
					}
				}
			}
			out.println(ans);
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