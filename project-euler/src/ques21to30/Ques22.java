package ques21to30;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;



//PROBLEM 22

//Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
//For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
//What is the total of all the name scores in the file?

		
public class Ques22{
	
	
	public static Map<Character, Integer> getAlPhabetMap(){
		Map<Character, Integer> alphabetMap = new HashMap<>();
		for(int i = 0; i < 26; i++){
			alphabetMap.put((char)(65+i), i+1);
		}		
		return alphabetMap;
	}
	
	
	public static List<String> getNameList(String fileName){
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        	stream.forEach((a)->{
        		String[] array = a.split("\\,");
        		Arrays.sort(array);
        		
        		for(int i=0;i<array.length;i++) {
        			String name = array[i].replaceAll("[\"]","");
        			list.add(name);
        		}
        	});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

	public static void main(String[] args) {
		
		List<String> names = getNameList(System.getenv("file_path"));
		Map<Character, Integer> alphabetMap = getAlPhabetMap();
		
		int result = 0;
		int count = 0;
		
		for(String name : names) {
			count++;
			int value = 0;
			for(int i=0;i<name.length();i++) {
				 value += alphabetMap.get(name.charAt(i));
			}
			value *= count;
			result += value;
		}
		System.out.println(result);
	}
}
