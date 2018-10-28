package rushtree;

import java.util.*;

public class AllOne {

    // maintain a doubly linked list of Buckets
    // small
    private Bucket head;
    //big
    private Bucket tail;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> countBucketMap;
    // keep track of count of keys
    private Map<String, Integer> keyCountMap;

    // each Bucket contains all the keys with the same count
    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket pre;

        public Bucket(int cnt) {
            count = cnt;
            keySet = new HashSet<>();
        }
    }

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (keyCountMap.containsKey(key)) {
            changeCount(key);
        } else {
            keyCountMap.put(key, 1);
            Integer count = keyCountMap.get(key);
            Bucket curBucket = countBucketMap.get(count);
            if (curBucket != null) {
                curBucket.keySet.add(key);
            } else {

                Bucket bucket = new Bucket(1);
                bucket.keySet.add(key);
                addBucketAfter(bucket, head);
                countBucketMap.put(1, bucket);
            }
        }
    }

    private void changeCount(String key) {
        Integer count = keyCountMap.get(key);
        Integer newCnt = count + 1;
        keyCountMap.put(key, newCnt);

        Bucket bucket = countBucketMap.get(count);
        Bucket bucketPlus = countBucketMap.get(newCnt);
        if (bucketPlus != null) {
            bucketPlus.keySet.add(key);

        } else {
            Bucket newBucket = new Bucket(newCnt);
            newBucket.keySet.add(key);
            countBucketMap.put(newCnt, newBucket);
            addBucketAfter(newBucket, bucket);
        }
        removeKeyFromBucket(bucket, key);

    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if (bucket.keySet.isEmpty()) {
            Bucket preBucket = bucket.pre;
            Bucket afterBucket = bucket.next;
            preBucket.next = afterBucket;
            afterBucket.pre = preBucket;
            countBucketMap.remove(bucket.count);
        }
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.next = preBucket.next;
        preBucket.next.pre = newBucket;
        preBucket.next = newBucket;
        newBucket.pre = preBucket;
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        Integer count = keyCountMap.get(key);
        if (count == null)
            return;

        Bucket bucket = countBucketMap.get(count);
        if (count == 1) {
            keyCountMap.remove(key);
            removeKeyFromBucket(bucket, key);
            return;
        }
        changeCountMinus(key);

    }

    private void changeCountMinus(String key) {
        Integer count = keyCountMap.get(key);
        Integer newCnt = count - 1;
        keyCountMap.put(key, newCnt);

        Bucket bucket = countBucketMap.get(count);
        Bucket bucketPlus = countBucketMap.get(newCnt);
        if (bucketPlus != null) {
            bucketPlus.keySet.add(key);
        } else {
            Bucket newBucket = new Bucket(newCnt);
            newBucket.keySet.add(key);
            countBucketMap.put(newCnt, newBucket);
            addBucketAfter(newBucket, bucket.pre);
        }
        removeKeyFromBucket(bucket, key);
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return head.next == tail ? "" : tail.pre.keySet.iterator().next();

    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {

        return head.next == tail ? "" : head.next.keySet.iterator().next();
    }


}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */