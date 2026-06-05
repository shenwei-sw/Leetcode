class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 0
        ret = None
        for num in nums:
            if count == 0: 
                ret = num
            count += 1 if num == ret else -1
        
        return ret
        