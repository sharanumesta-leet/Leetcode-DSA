/**
 * @param {string} moves
 * @return {number}
 */
var furthestDistanceFromOrigin = function (moves) {
    let dir = 0;
    let both = 0;
    for (let ch of moves) {
        if (ch === 'R') dir++;
        else if (ch === 'L') dir--;
        else both++;
    }
    return both + Math.abs(dir);
};