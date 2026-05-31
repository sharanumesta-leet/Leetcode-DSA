function asteroidsDestroyed(mass: number, asteroids: number[]): boolean {
    asteroids.sort((a, b) => a - b);
    let curMass = mass;
    let n = asteroids.length;
    for (let astr of asteroids) {
        if (curMass >= asteroids[n - 1]) return true;
        if (curMass < astr) return false;
        curMass += astr;
    }
    return true;
};