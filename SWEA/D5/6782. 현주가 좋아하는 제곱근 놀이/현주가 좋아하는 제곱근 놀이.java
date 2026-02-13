import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	private static int answer;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			answer = 0;
			sq(Long.parseLong(br.readLine()));
			System.out.println("#" + test_case + " " + answer);
		}
		
	}
	
	private static void sq(long n) {
		if(n == 2) return;
		
		long s = (long) Math.sqrt(n);
		
		// sqrt 오차 보정
		while((s+1) > 0 && (s+1) <= n / (s + 1)) s++;
		while(s > 0 && s > n / s) s--;
		
		if(s > 1 && s * s == n) { // 완전 제곱이면
			answer++; // 연산 1회
			sq(n / s);
		} else { // 아니면 다음 제곱수로 점프
			long t = s + 1;
			long nextSq = t * t; // Long이라 안전
			answer += (nextSq - n); // n을 next sq까지 올린 횟수
			sq(nextSq); // 다음 호출에서 바로 완전제곱 처리됨
		}
		
	}
}
