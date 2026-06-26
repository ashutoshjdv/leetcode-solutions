// Last updated: 6/26/2026, 8:55:23 AM
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {

    const output = [];

    nums.sort((a, b) => a - b);

    for (let i = 0; i < nums.length - 2; i++) {

        // skip duplicate i values

        if (i > 0 && nums[i] === nums[i - 1]) continue;

        let j = i + 1;

        let k = nums.length - 1;

        while (j < k) {

            const sum = nums[i] + nums[j] + nums[k];

            if (sum === 0) {

                output.push([nums[i], nums[j], nums[k]]);

                j++;

                k--;

                // skip duplicate j

                while (j < k && nums[j] === nums[j - 1]) {

                    j++;

                }

                // skip duplicate k

                while (j < k && nums[k] === nums[k + 1]) {

                    k--;

                }

            } 

            else if (sum > 0) {

                k--;

            } 

            else {

                j++;

            }

        }

    }

    return output;

};