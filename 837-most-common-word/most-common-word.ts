function mostCommonWord(paragraph: string, banned: string[]): string {
    let set: Set<string> = new Set(banned);
    let map: Map<string, number> = new Map();
    let text: string[] = paragraph.toLowerCase().split(/[^a-z]+/);
    let max = 0;
    let ans = "";
    for (let st of text) {
        if (set.has(st) || st.length === 0) continue;
        let count = (map.get(st) || 0) + 1;
        map.set(st, count);
        if (count > max) {
            max = count;
            ans = st;
        }
    }
    return ans;
};