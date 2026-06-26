// Last updated: 6/26/2026, 8:55:22 AM
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const result = new Array();
    if (nums === []) return [];
    const hashMap = new Map();
    nums.map((value, index) => {
        // console.log(hashMap);
        // console.log(hashMap.has((target - value)));
        if(hashMap.has((target - value)))
            {
                console.log([hashMap.get((target - value)),index]);
                result.push(hashMap.get((target-value)))
                result.push(index)
                return result;
            }

        hashMap.set(value,index);

    })
    return result;
};