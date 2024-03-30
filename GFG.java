import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
 
public class GFG {
	static int MAX_CHAR = 26;
	static int rearrangeString(int a, int b, int c)
	{
        int n = a+b+c;
		PriorityQueue<Key> pq
			= new PriorityQueue<>(new KeyComparator());
		
				pq.add(new Key(a, 'a'));
                pq.add(new Key(b, 'b'));
                pq.add(new Key(c, 'c'));
 
		String str = "";
		Key prev = new Key(-1, '#');
 
		while (pq.size() != 0) {
 
			Key k = pq.peek();
			pq.poll();
			str = str + k.ch;
			if (prev.freq > 0)
				pq.add(prev);
 
			(k.freq)--;
			prev = k;
		}
		if (n != str.length()){
            return n-str.length();
        }
		else
			//System.out.println(str);
            return 0;
	}
 
	public static void main(String args[])
	{
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int val = scan.nextInt();
            int maxi = a+b+c-3;
            
            int mini = rearrangeString(a,b,c);
            if (val>=mini && val<=maxi){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
        scan.close();
        
	}
}
 
class KeyComparator implements Comparator<Key> {
	public int compare(Key k1, Key k2)
	{
		if (k1.freq < k2.freq)
			return 1;
		else if (k1.freq > k2.freq)
			return -1;
		return 0;
	}
}
 
class Key {
	int freq;
	char ch;
	Key(int val, char c)
	{
		freq = val;
		ch = c;
	}
}