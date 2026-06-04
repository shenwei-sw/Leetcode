class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        start = 0
        set = {}
        for i in range(1, len(nums)): 
            if nums[i] == nums[start]:
                continue
            else:
                start += 1
                nums[start] = nums[i]
        return start + 1
        