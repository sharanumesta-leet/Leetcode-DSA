function maxIceCream(costs: number[], coins: number): number {
    costs.sort((a, b) => a - b);
    let curBar: number = 0;
    let count: number = 0;
    for (let cost of costs) {
        if ((curBar + cost) > coins)
            break;
        curBar += cost;
        count++;
    }
    return count;
};