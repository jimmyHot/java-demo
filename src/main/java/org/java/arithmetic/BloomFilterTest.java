package org.java.arithmetic;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {

    private static int size=10000;

    private static BloomFilter<Integer> filter= BloomFilter.create(Funnels.integerFunnel(),size,0.01f);
}
