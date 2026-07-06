function findRadius(houses: number[], heaters: number[]): number {
    houses.sort((a, b) => a - b);
    heaters.sort((a, b) => a - b);
    let ans = -1;
    for (let h of houses) {
        let nearestHeater = bs(h, heaters);
        ans = Math.max(ans, nearestHeater);
    }
    return ans;
};

const bs = (h: number, heaters: number[]): number => {
    let left = 0;
    let right = heaters.length - 1;

    if (h <= heaters[0]) return heaters[0] - h;
    if (h >= heaters[right]) return h - heaters[right];

    while (left <= right) {
        let mid = Math.floor((right + left) / 2);
        let heater = heaters[mid];
        if (h === heater) return 0;
        else if (h < heater) right = mid - 1;
        else left = mid + 1;
    }
    let dist1 = Math.abs(h - heaters[left]);
    let dist2 = Math.abs(h - heaters[right]);
    return Math.min(dist1, dist2);
}