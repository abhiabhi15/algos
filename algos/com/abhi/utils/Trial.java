package com.abhi.utils;

import java.util.Map;
import java.util.TreeMap;

public class Trial {

 Map<String,Object> map1 = new TreeMap<String,Object>();

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((map1 == null) ? 0 : map1.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Trial other = (Trial) obj;
	if (map1 == null) {
		if (other.map1 != null)
			return false;
	} else if (!map1.equals(other.map1))
		return false;
	return true;
}
 
 
 
	
}