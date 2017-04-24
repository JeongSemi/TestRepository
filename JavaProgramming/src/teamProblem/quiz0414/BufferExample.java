package teamProblem.quiz0414;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// 1 . ��� ��ο��� test.txt ������ �޾ƿ��� �ڵ� �ۼ� (1��)

		String path = BufferExample.class.getResource("test.txt").getPath();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		String readline = null;

		while (true) {
			readline = br.readLine();
			if (readline == null)
				break;
			// 2. test.txt������ ���� ������ �о���� �ڵ带 �ۼ��ϼ���. (�� 3��)

			System.out.println(readline);

			System.out.println("������ �ڸ� ������ �迭�� ���> ");
			// 3. String �迭�� ���ۿ��� ���� ������ ��.��(��)���� �����Ͽ� Arrays �迭�� ����ϼ���.
//			StringTokenizer st = new StringTokenizer(".");
//			while(st.hasMoreTokens())
//			{
//				String token = st.nextToken();
//				System.out.println(token);
//			}
			String[] tokens = readline.split("\\.");
			for(String s : tokens){
				System.out.println(s);
			}
			
		}

		br.close();
		fr.close();

	}
}
