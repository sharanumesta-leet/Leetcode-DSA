/**
 * @param {number[]} nums
 * @return {number}
 */
var minMirrorPairDistance = function (nums) {
    const map = new Map();
    let ans = Infinity;

    const reverse = (x) => {
        let y = 0;
        while (x > 0) {
            y = y * 10 + (x % 10);
            x = Math.floor(x / 10);
        }
        return y;
    };

    for (let i = 0; i < nums.length; i++) {
        let x = nums[i];

        if (map.has(x)) {
            ans = Math.min(ans, i - map.get(x));
        }

        map.set(reverse(x), i);
    }

    return ans === Infinity ? -1 : ans;
};