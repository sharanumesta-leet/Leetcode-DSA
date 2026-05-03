function rotateString(s: string, goal: string): boolean {
    if(s.length !== goal.length) return false;
    let str: string = s + s;
    return str.includes(goal);
};