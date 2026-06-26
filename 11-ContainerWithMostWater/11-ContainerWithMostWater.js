// Last updated: 6/26/2026, 8:55:18 AM
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function(height) {
    var output = 0;
    for(let i = 0, j = (height.length - 1) ; i < j ; ) {
        let tempArea = 0;
        if(height[i] >= height[j]) {
            tempArea = height[j] * (j - i);
            if(tempArea > output) output = tempArea;
            j--;
        }
        else {
            tempArea = height[i] * (j - i);
            if(tempArea > output) output = tempArea;
            i++;
        }
    }
    return output;
};