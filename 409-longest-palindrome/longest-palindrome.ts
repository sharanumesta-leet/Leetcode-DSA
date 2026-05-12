function longestPalindrome(s: string): number {
    const frequencyMap: Map<string, number> = new Map();

    for (const c of s) {
        frequencyMap.set(c, (frequencyMap.get(c) || 0) + 1);
    }

    let res: number = 0;
    let hasOddFrequency: boolean = false;

    for (const freq of frequencyMap.values()) {
        if (freq % 2 === 0) {
            res += freq;
        } else {
            res += freq - 1;
            hasOddFrequency = true;
        }
    }

    if (hasOddFrequency) return res + 1;

    return res;
}