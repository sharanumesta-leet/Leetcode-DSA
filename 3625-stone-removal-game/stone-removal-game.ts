/**
 * @param {number} n
 * @return {boolean}
 */
function canAliceWin(n: number): boolean {
    let remove = 10;
    let aliceTurn = true;
    while (remove > 0) {
        if (n < remove) return !aliceTurn;
        n -= remove;
        remove--;
        aliceTurn = !aliceTurn;
    }
    return false;
}