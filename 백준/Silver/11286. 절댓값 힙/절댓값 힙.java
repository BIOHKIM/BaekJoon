import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {
			int first_abs = Math.abs(o1);
			int second_abs = Math.abs(o2);
			if(first_abs == second_abs)
				return o1 > o2 ? 1:-1; 		//절대값이 같으면 음수 우선 정렬하기
			else
				return first_abs - second_abs;   //절대값을 기준으로 정렬하기
			
		});
		for(int i = 0; i < N; i++) {
			int request = Integer.parseInt(br.readLine());
			if(request == 0) {
				if(myQueue.isEmpty())
					System.out.println("0");
				else
					System.out.println(myQueue.poll());   // poll: front부분에 있는 데이터를 삭제하고 확인하는 연산이다.
			}else {
				myQueue.add(request);
			}
		}
	}
}