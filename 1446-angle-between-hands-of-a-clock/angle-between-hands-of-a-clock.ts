function angleClock(hour: number, minutes: number): number {
    let hrInDeg = ((hour * 30) + (minutes / 2)) % 360;
    let minInDeg = minutes * 6;

    let diff = Math.abs(hrInDeg - minInDeg);
    let ans = Math.min(360 - diff, diff);

    return Number(ans.toFixed(5));
};