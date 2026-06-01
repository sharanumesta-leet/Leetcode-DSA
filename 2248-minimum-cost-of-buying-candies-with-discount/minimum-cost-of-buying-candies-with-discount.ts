function minimumCost(cost: number[]): number {
    let total = 0;
    cost.sort((a, b) => b - a);
    for (let i = 0; i < cost.length; i++)
        if (((i + 1) % 3) !== 0)
            total += cost[i];
    return total;
}