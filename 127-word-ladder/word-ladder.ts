function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
    let wordListSet: Set<string> = new Set(wordList);
    if (!wordListSet.has(endWord)) return 0;
    wordListSet.delete(beginWord);

    let queue: string[] = [beginWord];
    let step = 1;
    let idx = 0;
    while (idx < queue.length) {
        let curLen = queue.length - idx;
        for (let i = 0; i < curLen; i++) {
            let curWord: string = queue[idx++];
            for (let j = 0; j < curWord.length; j++) {
                let wordArr = curWord.split("");
                for (let c = 97; c < 123; c++) {
                    wordArr[j] = String.fromCharCode(c);
                    let newWord = wordArr.join("");

                    if (newWord === endWord) return step + 1;

                    if (wordListSet.has(newWord)) {
                        queue.push(newWord);
                        wordListSet.delete(newWord);
                    }
                }
            }
        }
        step++;
    }
    return 0;
}


// function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
//     let n: number = wordList.length;
//     let isEndWordExist: boolean = false;
//     for (let str of wordList) {
//         if (str === endWord) {
//             isEndWordExist = true;
//             break;
//         }
//     }
//     if (!isEndWordExist) return 0;
//     let graph = new Map<string, string[]>();
//     for (let i = 0; i < n; i++) {
//         let srcStr: string = wordList[i];
//         if (canAdjacent(beginWord, srcStr))
//             buildGraph(graph, beginWord, srcStr);
//         for (let j = i + 1; j < n; j++) {
//             let destStr: string = wordList[j];
//             if (canAdjacent(srcStr, destStr)) {
//                 buildGraph(graph, srcStr, destStr);
//             }
//         }
//     }
//     return bfs(graph, beginWord, endWord);
// };

// const buildGraph = (graph: Map<string, string[]>, srcStr: string, destStr: string): void => {
//     if (!graph.has(srcStr)) graph.set(srcStr, []);
//     if (!graph.has(destStr)) graph.set(destStr, []);
//     graph.get(srcStr)!.push(destStr);
//     graph.get(destStr)!.push(srcStr);
// }

// const canAdjacent = (srcStr: string, destStr: string): boolean => {
//     let srcArr: string[] = srcStr.split("");
//     let destArr: string[] = destStr.split("");
//     let n: number = srcArr.length;
//     let count: number = 0;
//     for (let i = 0; i < n; i++) {
//         if (srcArr[i] !== destArr[i]) count++;
//         if (count >= 2) return false;
//     }
//     return count === 1;
// }

// const bfs = (graph: Map<string, string[]>, beginWord: string, endWord: string): number => {
//     let ans: number = 1;
//     let queue: string[] = [];
//     let set: Set<string> = new Set();
//     queue.push(beginWord);
//     set.add(beginWord);
//     while (queue.length) {
//         ans++;
//         let curLen: number = queue.length;
//         for (let i = 0; i < curLen; i++) {
//             let cur: string = queue.shift();
//             for (let neig of graph.get(cur)) {
//                 if (!set.has(neig)) {
//                     if (neig === endWord) return ans;
//                     set.add(neig);
//                     queue.push(neig);
//                 }
//             }
//         }
//     }
//     return 0;
// }