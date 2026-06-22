function maxNumberOfBalloons(text: string): number {
    let ans: number = Infinity;
    let chars: string = "balon";
    let map = new Map<string, number>();

    for (let ch of text)
        if (chars.includes(ch))
            map.set(ch, (map.get(ch) || 0) + 1);

    if (map.size !== 5) return 0;
    for (let [key, val] of map) {
        if (key === 'l' || key === 'o')
            ans = Math.min(ans, Math.floor(val / 2));
        else
            ans = Math.min(ans, val);
    }

    return ans;
};