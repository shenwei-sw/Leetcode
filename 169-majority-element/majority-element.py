class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        count = 1
        indexMax = 0
        for i in range(1, len(nums)):
            if nums[i] == nums[indexMax]:
                count += 1
            else:
                count -= 1
            
            if count == 0:
                count = 1
                indexMax = i
        
        return nums[indexMax]
        