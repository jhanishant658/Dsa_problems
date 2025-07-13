function once(fn) {
    let called = false;  // Track if fn has been called
    let result;

    return function(...args) {
        if (!called) {
            called = true;
            result = fn(...args);  // Call fn with arguments
            return result;
        } else {
            return undefined;  // Ignore future calls
        }
    }
}

/**
 * let fn = (a,b,c) => (a + b + c)
 * let onceFn = once(fn)
 *
 * onceFn(1,2,3); // 6
 * onceFn(2,3,6); // returns undefined without calling fn
 */
