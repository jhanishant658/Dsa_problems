/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    // Return a new function that takes input x
    return function(x) {
        // Start with x
        let result = x;

        // Go through the functions from last to first
        for (let i = functions.length - 1; i >= 0; i--) {
            let func = functions[i];
            result = func(result); // Apply the function
        }

        return result; // Final result after applying all functions
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */