package interviewprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class projdep {
	
	static <T> List sort(List<T> projects, List<List<T>> pairs) {
//		Set<> checkdup = new HashSet<>(pairs);
//		if (checkdup.size() != pairs.size()) {
//			System.out.println("Error: List contains duplicate dependencies; unable to build");
//			return null;
//		}
		
// This was my attempt to try and return an error if there is no valid build order. Or in the case of circular dependencies.
// The goal was to try and find the indirect chain of dependencies for each project, and map it in a key-value pair where the value was
// a list. Then determine if the build is valid or not. Was not able to get it to work fully
		
//		Map<T,List<T>> check = new HashMap<T,List<T>>();
//		List<T> multival = new ArrayList<>();
//		List<T> multival2 = new ArrayList<>();
//		for(int i=0;i<projects.size(); i++) {
//			multival.add(projects.get(i));
//			ListIterator ch = multival.listIterator();
//			while(ch.hasNext()) {
//				Object b = ch.next();
//				System.out.println(b);
//				pairs.forEach(a -> {
//					if(b == a.get(0)) {
//						ch.add(a.get(1));
//						multival2.add(a.get(1));
//					}
//				});
//			}
//			check.put(projects.get(i), multival2);
//			multival.clear();
//			multival2.clear();
//		}
		
//	This is the main code that works for the given example. It iterates through the pairs and determines the position of each dependency..
//	However, it may not work for certain situations or repeats when an error is present.
		
		pairs.forEach(a -> {
			Object main0 = a.get(0);
			Object dep0 = a.get(1);
			int main = (int) projects.indexOf(main0);
			int dep = (int) projects.indexOf(dep0);
			while (dep < main) {
				Collections.swap(projects, main-1, main);
				main = (int) projects.indexOf(main0);
			}
		});
		return projects;
	}
	
	public static <T> void main(String[] args) {
		List projects =  Arrays.asList('a','b','c','d','e','f');
		List pairs = Arrays.asList(Arrays.asList('a','d'), Arrays.asList('f', 'b'), Arrays.asList('b', 'd'), Arrays.asList('f', 'a'), Arrays.asList('d', 'c'));
		
		System.out.println(sort(projects,pairs));
		// Output: [f, a, b, d, c, e]
		
	}

}
