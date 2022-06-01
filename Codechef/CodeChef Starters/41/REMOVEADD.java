import java.util.*;
import java.io.*;
class A{
	static FastScanner fs = null;
	public static void main(String[] args) {
		fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int t = fs.nextInt();
		while (t-->0) {
			int n = fs.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++){
				a[i] = fs.nextInt();
			}
			Map<Integer,Integer> map= new HashMap<>();
			for(int i=0;i<n;i++){
				int num= a[i];
				if(map.get(num)==null){
					map.put(num,1);
				}
				else
					map.replace(num,1+map.get(num));
			}
			Set<Integer> st = new HashSet<>();
			for(Map.Entry<Integer,Integer> entry : map.entrySet()){
				int ke = entry.getKey();
				int vl = entry.getValue();
				if(vl>1){
					st.add(ke);
				}
			}
			boolean re[] = new boolean[n];
			int id = 0;
			// out.println(st.size()+" ---");
			for(int i=0;i<n;i++){
				// out.println(st.size()+ " ---");
				if(st.size()==0){
					id = i;
					break;
				}
				int num = a[i];
				if(map.get(num)==1){
					continue;
				}
				else{
					re[i] = true;
					int d = map.get(num);
					d-=1;
					// out.println(i+" "+d);
					map.replace(num,d);
					if(d==1){
						st.remove(num);
					}
				}
			}
			id-=1;
			if(id==-1){
				out.println("0");
			}
			else{
				Map<Integer,Integer> mp=new HashMap<>();
				Map<Integer,Integer> mp2=new HashMap<>();
				int c = n-1;
				int ans = id+1;
				for(int i=id;i>=0;i--){
					// out.println(ans+" --"+i);
					if(re[i]){
						int num = a[i];
						if(mp2.get(num)==null){
								mp2.put(num,1);
							}
							else
								mp2.replace(num,1+mp2.get(num));
						for(;c>=0;){
							if(mp.containsKey(num)){
								if(mp.get(num) >= mp2.get(num)){
									int x =i;
									int y = n-c-1;
									int mx = Math.max(x,y);
									int mn = Math.min(x,y);
									ans = Math.min(ans,2*mn+mx);
									break;
								}
							}
							int num2 = a[c];
							if(mp.get(num2)==null){
								mp.put(num2,1);
							}
							else
								mp.replace(num2,1+mp.get(num2));
							c-=1;
						}
					}
					else{
						int x =i;
						int y = n-c-1;
						int mx = Math.max(x,y);
						int mn = Math.min(x,y);
						// out.println((2*mn+mx)+" "+i+" ---"+mn+" "+mx+" "+c);
						ans = Math.min(ans,2*mn+mx);
					}
				}
				out.println(ans);
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
