import java.util.*;

public class CodonProfiler {
/**
* Count how many times each codon in an array of codons occurs
* in a strand of DNA. Return int[] such that int[k] is number
* of occurrences of codons[k] in strand. Strand codons can start
* at all valid indexes that are multiples of 3: 0, 3, 6, 9, 12, ...
* @param strand is DNA to be analyzed for codon occurrences.
* @param codons is an array of strings, each has three characters
* @return int[] such that int[k] is number of occurrences of codons[k] in 
* strand. 
*/
	public int[] getCodonProfile(IDnaStrand strand, String[] codons) {
		HashMap<String,Integer> map = new HashMap<>();
		int[] ret = new int[codons.length];
		Iterator<Character> iter = strand.iterator();
		while (iter.hasNext()) {
			char a = iter.next();
			char b = 'z';           
			char c = 'z';
			if (iter.hasNext()) {
				b = iter.next();
			}
			if (iter.hasNext()) {
				c = iter.next();
			}
			else {
				break;
			}
			String cod = ""+a+b+c;
			if (! map.containsKey(cod) ) {
				map.put(cod, 1);
			}
			else {
				map.put(cod, map.get(cod) + 1);
			}
		}
		for (int m = 0; m < codons.length; m++) {
			if (! map.containsKey(codons[m])) {
				ret[m] = 0;
			}
			else {
				ret[m] = map.get(codons[m]);
			}
		}
		return ret;
	}
}
