function largestAltitude(gain: number[]): number {
    let max = 0;
    let arrSum = 0

    for (let i = 0; i < gain.length; i++) {
        arrSum += gain[i]
        max = Math.max(arrSum, max)
    }
    return max

};