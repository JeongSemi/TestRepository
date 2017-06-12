
package teamProblem.quiz0414_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("src\\study0414\\exam02\\object.dat"); // 寃쎈줈�뒗
																							// �뙣�궎吏��뿉
																							// 留욊쾶
																							// �븣�븘�꽌
																							// �닔�젙�븯�꽭�슂...

		// 媛앹껜�엯�젰�뒪�듃由쇱쓣 �깮�꽦�븯�꽭�슂.(1以�)
		ObjectInputStream ois = new ObjectInputStream(fis);

		// �옄�떇 媛앹껜�뿉 �엳�뒗 �궡�슜�쓣 �씫�뼱�삤�뒗 肄붾뱶瑜� �옉�꽦�븯�꽭�슂 (1以�)

		// 遺�紐� 媛앹껜 �븘�뱶�쓽 媛믪쓣 �씫�뼱�삤�뒗 異쒕젰臾� 2媛� �옉�꽦(name, age)

		// �옄�떇 媛앹껜 �븘�뱶�쓽 媛믪쓣 �씫�뼱�삤�뒗 異쒕젰臾� 2媛� �옉�꽦(membershipNo, grade)

		ois.close();
		fis.close();

	}

}
