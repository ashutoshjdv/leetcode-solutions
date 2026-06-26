// Last updated: 6/26/2026, 8:55:15 AM
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    let output = -Infinity;
        let tempMax = 0;
        for (let i =0; i< nums.length; i++) {
            tempMax = tempMax + nums[i];
            output = Math.max(output, tempMax);
            if(tempMax < 0) tempMax = 0;
        }
        return output;
};