/**
 * @param {string} word
 * @return {number}
 */
var minTimeToType = function (word) {
    let ans = 0;
    let char = 'a';
    for (let ch of word) {
        let diff = Math.abs(ch.charCodeAt(0) - char.charCodeAt(0));
        ans += Math.min(diff, 26 - diff);
        ans++;
        char = ch;
    }
    return ans;
};