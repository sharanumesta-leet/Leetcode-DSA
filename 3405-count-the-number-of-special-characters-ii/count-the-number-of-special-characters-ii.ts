function numberOfSpecialChars(word: string): number {
    let map: Map<string, number> = new Map();
    let n = word.length;

    for (let i = 0; i < n; i++) {
        let ch = word[i];
        if (ch >= 'a' && ch <= 'z') {
            map.set(ch, i);
        } else {
            if (!map.has(ch))
                map.set(ch, i);
        }
    }

    let count = 0;
    for (let code = 65; code <= 90; code++) {
        let ch: string = String.fromCharCode(code);
        if (map.has(ch) && map.has(ch.toLowerCase()))
            if (map.get(ch.toLowerCase()!) < map.get(ch)!)
                count++;
    }
    return count;
};