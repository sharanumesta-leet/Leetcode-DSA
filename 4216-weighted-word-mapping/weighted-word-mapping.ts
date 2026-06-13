function mapWordWeights(words: string[], weights: number[]): string {
    return words.map((word) => {
        let weight = 0;
        word.split('').forEach((ch) => {
            let charNo = ch.charCodeAt(0) - 97;
            weight = (weight + weights[charNo]) % 26;
        });
        return String.fromCharCode(96 + 26 - weight);
    }).join('');
};