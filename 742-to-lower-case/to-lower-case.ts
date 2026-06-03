/**
 * @param {string} s
 * @return {string}
 */
var toLowerCase = function (s) {
    let ans: string = "";
    for (let ch of s) {
        let code = ch.charCodeAt(0);
        if (code >= 65 && code <= 90)
            code += 32;
        ans += String.fromCharCode(code);
    }
    return ans
};