package d1.commons;

import java.util.Random;

public class StringHelper {
	public static int findNextString(String content, int fromIndex, char tag) {
		boolean isfound = false;
		int index = fromIndex;
		while (!isfound) {
			index++;
			if(index>=content.length()){
				isfound = true;
				break;
			}
			if (content.charAt(index) == tag)
				isfound = true;
		}
		return index;
	}

	//生成num位随机码
	public static String getFourRandom(int num){
		Random random = new Random();
		String fourRandom = random.nextInt(10000) + "";
		int randLength = fourRandom.length();
		if(randLength<num){
			for(int i=1; i<=num-randLength; i++)
				fourRandom = "0" + fourRandom  ;
		}
		return fourRandom;
	}
}
