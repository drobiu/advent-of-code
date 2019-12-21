let fs = require('fs');
let input = fs.readFileSync('data/data_6.txt', 'utf8').split('\r\n');

var orbits = {};

for (var i = 0; i < input.length; i++) {
    orbits[i] = input[i].split(')');
}

class Node {
    constructor(string, prev) {
        this.name = string;
        this.prev = prev;
    }
    getString() {
        return this.string;
    }
    getPrev() {
        return this.prev;
    }
    setPrev(prev) {
        this.prev = prev;
    }
    countOrbits() {
        if (this.prev == null)
            return 1;
        return 1 + this.prev.countOrbits();
    }
}

var dict = {};

for (var i = 0; i < input.length; i++) {
    let orbit = orbits[i];
    let name = orbit[1];
    n = new Node(name, null);
    dict[name] = n;
}

for (var i = 0; i < input.length; i++) {
    let orbit = orbits[i];
    let name = orbit[1];
    if (orbit[0] == 'COM')
        dict[name].setPrev(null);
    else
        dict[name].setPrev(dict[orbit[0]]);
}

let sum = 0;

for (var i = 0; i < input.length; i++) {
    sum += dict[orbits[i][1]].countOrbits();
}

console.log(sum);