
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());
		int Result = 0;

		// A 배열에 수의 개수를 넣어야 함
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());

		// N만큼 반복하기
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);

		// k를 0부터 N까지 반복
		for (int k = 0; k < N; k++) {
			long find = A[k];
			int i = 0; // 시작
			int j = N - 1; // 끝값이기때문에 N-1
			// 투포인터 알고리즘

			while (i < j) {
				if (A[i] + A[j] == find) {
					// find는 서로 다른 두 수의 합이어야 함을 체크
					if (i != k && j != k) {
						Result++;

						break;
					} else if (i == k) {
						i++;
					} else if (j == k) {
						j--;
					}
				} else if (A[i] + A[j] < find) {
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(Result);
		bf.close();
	}
}