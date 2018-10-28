package rushtree;

import java.util.Arrays;

public class kth {
    /*sort(nums.begin(), nums.end());
    int n = nums.size(), left = 0, right = nums.back() - nums[0];
        while (left < right) {
        int mid = left + (right - left) / 2, cnt = 0, start = 0;
        for (int i = 0; i < n; ++i) {
            while (start < n && nums[i] - nums[start] > mid) ++start;
            cnt += i - start;
        }
        if (cnt < k) left = mid + 1;
        else right = mid;
    }
        return right;*/
//     Arrays.sort(nums);

   /* int l =0;
    int h =nums[nums.length-1]-nums[0];
       while(l<h){//二分查找，因为当count==k时，搜索到的m差值可能并不存在，需要继续循环判断，直到范围确定
        int m = (l + h)/2;
        //search
        //使用窗口思想，判断差值<=k的个数，r-l即表示[l,r]间间隔<m的个数（每确定一个窗口就新增加了（r-l+1）- 1个差值对）
        int left = 0;
        int count = 0;
        for(int right = 0;right<nums.length;right++){
            while(nums[right] - nums[left]>m){
                left++;
            }
            count+= right-left;
            }
             if(count>=k){
               h = m ;
           }else{
               l = m+1;
           }
            */


    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, left = 0, right = nums[n-1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0, start = 0;
            for (int i = 0; i < n; ++i) {
                while (start < n && nums[i] - nums[start] > mid) ++start;
                cnt += i - start;
            }
            if (cnt < k) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
