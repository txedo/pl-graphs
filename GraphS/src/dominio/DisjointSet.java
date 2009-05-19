package dominio;

import java.util.ArrayList;
import java.util.Collection;


public class DisjointSet<E extends Comparable<E>> {

    /* http://algowiki.net/wiki/index.php/Disjoint-set */
	private ArrayList<ArrayList<E>> set = new ArrayList<ArrayList<E>>();

	public void createSubsets(E[] items){
		for(E item : items){
			ArrayList<E> subset = new ArrayList<E>();
			subset.add(item);
			set.add(subset);
		}
	}

	public void createSubsets(Collection<E> items){
		for(E item : items){
			ArrayList<E> subset = new ArrayList<E>();
			subset.add(item);
			set.add(subset);
		}
	}

	public void merge(int setA, int setB){
		set.get(setA).addAll(set.get(setB));
		set.remove(setB);
	}

	public int find(E searchfor){
		for(int i=0; i<set.size(); i++){
			for(E item : set.get(i)){
				if(item.compareTo(searchfor)==0){
					return i;
				}
			}
		}
		return -1;
	}
}
