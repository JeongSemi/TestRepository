package teamProblem.quiz0414;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// 1 . 상대 경로에서 test.txt 파일을 받아오는 코드 작성 (1줄)

		String path = BufferExample.class.getResource("test.txt").getPath();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		String readline = null;

		while (true) {
			readline = br.readLine();
			if (readline == null)
				break;
			// 2. test.txt파일을 라인 단위로 읽어오는 코드를 작성하세요. (약 3줄)

			System.out.println(readline);

			System.out.println("점으로 자른 내용을 배열로 출력> ");
			// 3. String 배열로 버퍼에서 받은 내용을 ‘.’(점)으로 구분하여 Arrays 배열로 출력하세요.
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
