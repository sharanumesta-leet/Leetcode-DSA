/**
 * @param {string[]} queries
 * @param {string[]} dictionary
 * @return {string[]}
 */
const checkDiff = (s1, s2) => {
    let count = 0;
    for (let i = 0; i < s1.length; i++) {
        if (s1[i] !== s2[i]) count++;
        if (count >= 3) return count;
    }
    return count;
}

var twoEditWords = function (queries, dictionary) {
    let ans = [];
    for (let src of queries) {
        for (let word of dictionary) {
            let dif = checkDiff(src, word);
            if (dif < 3) {
                ans.push(src);
                break;
            }
        }
    }
    return ans;
};