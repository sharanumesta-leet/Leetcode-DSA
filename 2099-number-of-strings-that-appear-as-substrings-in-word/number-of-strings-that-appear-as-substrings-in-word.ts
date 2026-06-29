function numOfStrings(patterns: string[], word: string): number {
    let count = 0;
    for (let pt of patterns) {
        if(word.includes(pt))
            count++;
    }
    return count;
};